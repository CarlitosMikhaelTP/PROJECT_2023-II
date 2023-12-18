import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

const Propietarios = () => {
  const [dueños, setDueños] = useState([]);
  const [dueñoEditando, setDueñoEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    id_usuario: '',
    calificacion: '',
    comentario: '',
    preferencias_paseo: '',
    saldo: '',
    disponibilidad: '',
    ubicacion: '',
    estado: '',
  });
  const [filtroIdPropietario, setFiltroIdPropietario] = useState('');

  const fetchDueños = async () => {
    try {
      const data = await api.obtenerDueños();
      setDueños(data);
    } catch (error) {
      console.error('Error al obtener dueños:', error);
    }
  };

  useEffect(() => {
    fetchDueños();
  }, []);

  const eliminarDueño = (id) => {
    api.eliminarDueño(id)
      .then(() => {
        fetchDueños();
      })
      .catch((error) => console.error('Error al eliminar dueño:', error));
  };

  const handleEditar = (propietario) => {
    setDueñoEditando(propietario);
    setDatosEdicion({
      id_usuario: propietario.id_usuario.id_usuario,
      calificacion: propietario.calificacion,
      comentario: propietario.comentario,
      preferencias_paseo: propietario.preferencias_paseo,
      saldo: propietario.saldo,
      disponibilidad: propietario.disponibilidad,
      ubicacion: propietario.ubicacion,
      estado: propietario.estado,
    });
  };

  const cancelarEdicion = () => {
    setDueñoEditando(null);
    setDatosEdicion({
      id_usuario: '',
      calificacion: '',
      comentario: '',
      preferencias_paseo: '',
      saldo: '',
      disponibilidad: '',
      ubicacion: '',
      estado: '',
    });
  };

  const handleInputChangeEditarDueño = (e) => {
    const { name, value } = e.target;

    setDatosEdicion((prevDatosEdicion) => ({
      ...prevDatosEdicion,
      [name]: value,
    }));
  };

  const editarDueño = () => {
    if (dueñoEditando) {
      api.editarDueño(dueñoEditando.id_propietario, datosEdicion)
        .then(() => {
          fetchDueños();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar dueño:', error));
    }
  };

  const filtrarPorIdPropietario = (dueños, filtro) => {
    return dueños.filter((dueño) =>
      String(dueño.id_propietario).toLowerCase().includes(filtro.toLowerCase())
    );
  };

  const dueñosFiltrados = filtrarPorIdPropietario(dueños, filtroIdPropietario);

  const toggleEstadoDueño = (id, nuevoEstado) => {
    api.editarDueño(id, { estado: nuevoEstado })
      .then(() => {
        fetchDueños();
      })
      .catch((error) => console.error('Error al cambiar el estado del propietario:', error));
  };

  const activarDueño = (id) => {
    toggleEstadoDueño(id, '1');
  };

  const desactivarDueño = (id) => {
    toggleEstadoDueño(id, '0');
  };

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
            <a className="navbar-brand">Dueños</a>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por ID del Propietario"
                aria-label="Buscar"
                value={filtroIdPropietario}
                onChange={(e) => setFiltroIdPropietario(e.target.value)}
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
              <th>ID Propietario</th>
              <th>ID Usuario</th>
              <th>Calificación</th>
              <th>Comentario</th>
              <th>Preferencias de Paseo</th>
              <th>Saldo</th>
              <th>Disponibilidad</th>
              <th>Ubicación</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {dueñosFiltrados.map((propietario) => (
              <tr key={propietario.id_propietario}>
                <td>{propietario.id_propietario}</td>
                <td>
                  {dueñoEditando === propietario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="id_usuario"
                      value={datosEdicion.id_usuario}
                      onChange={handleInputChangeEditarDueño}
                    />
                  ) : (
                    propietario.id_usuario.id_usuario
                  )}
                </td>
                <td>
                  {dueñoEditando === propietario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="calificacion"
                      value={datosEdicion.calificacion}
                      onChange={handleInputChangeEditarDueño}
                    />
                  ) : (
                    propietario.calificacion
                  )}
                </td>
                <td>
                  {dueñoEditando === propietario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="comentario"
                      value={datosEdicion.comentario}
                      onChange={handleInputChangeEditarDueño}
                    />
                  ) : (
                    propietario.comentario
                  )}
                </td>
                <td>
                  {dueñoEditando === propietario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="preferencias_paseo"
                      value={datosEdicion.preferencias_paseo}
                      onChange={handleInputChangeEditarDueño}
                    />
                  ) : (
                    propietario.preferencias_paseo
                  )}
                </td>
                <td>
                  {dueñoEditando === propietario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="saldo"
                      value={datosEdicion.saldo}
                      onChange={handleInputChangeEditarDueño}
                    />
                  ) : (
                    propietario.saldo
                  )}
                </td>
                <td>
                  {dueñoEditando === propietario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="disponibilidad"
                      value={datosEdicion.disponibilidad}
                      onChange={handleInputChangeEditarDueño}
                    />
                  ) : (
                    propietario.disponibilidad
                  )}
                </td>
                <td>
                  {dueñoEditando === propietario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="ubicacion"
                      value={datosEdicion.ubicacion}
                      onChange={handleInputChangeEditarDueño}
                    />
                  ) : (
                    propietario.ubicacion
                  )}
                </td>
                <td>
                  {dueñoEditando === propietario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="estado"
                      value={datosEdicion.estado}
                      onChange={handleInputChangeEditarDueño}
                    />
                  ) : (
                    propietario.estado
                  )}
                </td>
                <td>
                  {dueñoEditando === propietario ? (
                    <>
                      <button onClick={editarDueño} className="btn btn-success btn-sm">
                        Guardar
                      </button>
                      <button onClick={cancelarEdicion} className="btn btn-secondary btn-sm">
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => handleEditar(propietario)} className="btn btn-warning btn-sm">
                        Editar
                      </button>
                      <button onClick={() => eliminarDueño(propietario.id_propietario)} className="btn btn-danger btn-sm">
                        Eliminar
                      </button>
                      <button
                        onClick={() => toggleEstadoDueño(propietario.id_propietario, propietario.estado === '1' ? '0' : '1')}
                        className={`btn btn-${propietario.estado === '1' ? 'danger' : 'success'} btn-sm`}
                      >
                        {propietario.estado === '1' ? 'Desactivar' : 'Activar'}
                      </button>
                      <button
                        onClick={() => desactivarDueño(propietario.id_propietario)} 
                        className="btn btn-secondary btn-sm"
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

export default Propietarios;
