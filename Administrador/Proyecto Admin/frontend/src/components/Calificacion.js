import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

const CalificacionesComentarios = () => {
  const [calificaciones, setCalificaciones] = useState([]);
  const [calificacionEditando, setCalificacionEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    comentario: '',
    calificacion: '',
    estado: '',
  });
  const [filtroIdPaseo, setFiltroIdPaseo] = useState('');

  const fetchCalificaciones = async () => {
    try {
      const data = await api.obtenerCalificaciones();
      setCalificaciones(data);
    } catch (error) {
      console.error('Error al obtener calificaciones y comentarios:', error);
    }
  };

  useEffect(() => {
    fetchCalificaciones();
  }, []);

  const eliminarCalificacion = (id) => {
    api.eliminarCalificacion(id)
      .then(() => {
        fetchCalificaciones();
      })
      .catch((error) => console.error('Error al eliminar calificación y comentario:', error));
  };

  const handleEditar = (calificacion) => {
    setCalificacionEditando(calificacion);
    setDatosEdicion({
      comentario: calificacion.comentario,
      calificacion: calificacion.calificacion,
      estado: calificacion.estado,
    });
  };

  const cancelarEdicion = () => {
    setCalificacionEditando(null);
    setDatosEdicion({
      comentario: '',
      calificacion: '',
      estado: '',
    });
  };

  const handleInputChangeEditarCalificacion = (e) => {
    const { name, value } = e.target;

    setDatosEdicion((prevDatosEdicion) => ({
      ...prevDatosEdicion,
      [name]: value,
    }));
  };

  const editarCalificacion = () => {
    if (calificacionEditando) {
      api.editarCalificacion(calificacionEditando.id_calificacioncomentario, datosEdicion)
        .then(() => {
          fetchCalificaciones();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar calificación y comentario:', error));
    }
  };

  const toggleEstadoCalificacion = (id, nuevoEstado) => {
    api.editarCalificacion(id, { estado: nuevoEstado })
      .then(() => {
        fetchCalificaciones();
      })
      .catch((error) => console.error('Error al cambiar el estado de la calificación:', error));
  };

  const activarCalificacion = (id) => {
    toggleEstadoCalificacion(id, '1');
  };

  const desactivarCalificacion = (id) => {
    toggleEstadoCalificacion(id, '0');
  };

  const filtrarPorIdPaseo = (calificaciones, filtro) => {
    return calificaciones.filter((calificacion) =>
      String(calificacion.id_paseo.id_paseo).toLowerCase().includes(filtro.toLowerCase())
    );
  };

  const calificacionesFiltradas = filtrarPorIdPaseo(calificaciones, filtroIdPaseo);

  return (
    <div style={{
      background: '#1D976C',
      background: '-webkit-linear-gradient(to right, #93F9B9, #1D976C)', 
      background: 'linear-gradient(to right, #93F9B9, #1D976C)' 
    }}>
      <div className="d-flex justify-content-between align-items-center">
      </div>
      <div className="mb-3">
        <nav className="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
          <div className="container-fluid">
            <a className="navbar-brand">Calificaciones y Comentarios</a>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por ID del Paseo"
                aria-label="Buscar"
                value={filtroIdPaseo}
                onChange={(e) => setFiltroIdPaseo(e.target.value)}
              />
              <button className="btn btn-outline-success" type="submit">
                Buscar
              </button>
              <Link to="/menu" className="btn btn-primary">
                Volver al Menú
              </Link>
            </form>
          </div>
        </nav>
      </div>
      <div className="table-responsive">
        <table className="table table-striped">
          <thead>
            <tr>
              <th>ID Calificación</th>
              <th>ID Paseo</th>
              <th>Comentario</th>
              <th>Calificación</th>
              <th>Estado</th>
              <th>Fecha Calificación</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {calificacionesFiltradas.map((calificacion) => (
              <tr key={calificacion.id_calificacioncomentario}>
                <td>{calificacion.id_calificacioncomentario}</td>
                <td>{calificacion.id_paseo.id_paseo}</td>
                <td>
                  {calificacionEditando === calificacion ? (
                    <input
                      type="text"
                      className="form-control"
                      name="comentario"
                      value={datosEdicion.comentario}
                      onChange={handleInputChangeEditarCalificacion}
                    />
                  ) : (
                    calificacion.comentario
                  )}
                </td>
                <td>
                  {calificacionEditando === calificacion ? (
                    <input
                      type="text"
                      className="form-control"
                      name="calificacion"
                      value={datosEdicion.calificacion}
                      onChange={handleInputChangeEditarCalificacion}
                    />
                  ) : (
                    calificacion.calificacion
                  )}
                </td>
                <td>
                  {calificacionEditando === calificacion ? (
                    <input
                      type="text"
                      className="form-control"
                      name="estado"
                      value={datosEdicion.estado}
                      onChange={handleInputChangeEditarCalificacion}
                    />
                  ) : (
                    calificacion.estado
                  )}
                </td>
                <td>{calificacion.fecha_calificacioncomentario}</td>
                <td>
                  {calificacionEditando === calificacion ? (
                    <>
                      <button onClick={editarCalificacion} className="btn btn-success btn-sm">
                        Guardar
                      </button>
                      <button onClick={cancelarEdicion} className="btn btn-secondary btn-sm">
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => handleEditar(calificacion)} className="btn btn-warning btn-sm">
                        Editar
                      </button>
                      <button onClick={() => eliminarCalificacion(calificacion.id_calificacioncomentario)} className="btn btn-danger btn-sm">
                        Eliminar
                      </button>
                      <button
                        onClick={() => calificacion.estado === '1' ? desactivarCalificacion(calificacion.id_calificacioncomentario) : activarCalificacion(calificacion.id_calificacioncomentario)}
                        className={`btn btn-${calificacion.estado === '1' ? 'danger' : 'success'} btn-sm`}
                      >
                        {calificacion.estado === '1' ? 'Desactivar' : 'Activar'}
                      </button>
                      <button
                        onClick={() => desactivarCalificacion(calificacion.id_calificacioncomentario)}
                        className={`btn btn-secondary btn-sm`}
                      >
                        Desactivar
                      </button>
                    </>
                  )}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default CalificacionesComentarios;
