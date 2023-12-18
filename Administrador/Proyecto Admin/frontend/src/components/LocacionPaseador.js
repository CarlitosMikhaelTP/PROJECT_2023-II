import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

const LocacionPaseador = () => {
  const [ubicaciones, setUbicaciones] = useState([]);
  const [ubicacionEditando, setUbicacionEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    id_paseador: '',
    latitud: '',
    longitud: '',
    estado: '',
  });
  const [filtroIdPaseador, setFiltroIdPaseador] = useState('');

  const fetchUbicaciones = async () => {
    try {
      const data = await api.obtenerLocacionPaseadores();
      setUbicaciones(data);
    } catch (error) {
      console.error('Error al obtener ubicaciones:', error);
    }
  };

  useEffect(() => {
    fetchUbicaciones();
  }, []);

  const eliminarUbicacion = (id) => {
    api.eliminarLocacionPaseadores(id)
      .then(() => {
        fetchUbicaciones();
      })
      .catch((error) => console.error('Error al eliminar ubicación:', error));
  };

  const handleEditar = (ubicacion) => {
    setUbicacionEditando(ubicacion);
    setDatosEdicion({
      id_paseador: ubicacion.id_paseador.id_paseador,
      latitud: ubicacion.latitud,
      longitud: ubicacion.longitud,
      estado: ubicacion.estado,
    });
  };

  const cancelarEdicion = () => {
    setUbicacionEditando(null);
    setDatosEdicion({
      id_paseador: '',
      latitud: '',
      longitud: '',
      estado: '',
    });
  };

  const handleInputChangeEditarUbicacion = (e) => {
    const { name, value } = e.target;

    setDatosEdicion((prevDatosEdicion) => ({
      ...prevDatosEdicion,
      [name]: value,
    }));
  };

  const editarUbicacion = () => {
    if (ubicacionEditando) {
      api.editarLocacionPaseadores(ubicacionEditando.id_locacion_paseador, datosEdicion)
        .then(() => {
          fetchUbicaciones();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar ubicación:', error));
    }
  };

  const filtrarPorIdPaseador = (ubicaciones, filtro) => {
    return ubicaciones.filter((ubicacion) =>
      String(ubicacion.id_locacion_paseador).toLowerCase().includes(filtro.toLowerCase())
    );
  };

  const ubicacionesFiltradas = filtrarPorIdPaseador(ubicaciones, filtroIdPaseador);

  const toggleEstadoUbicacion = (id, nuevoEstado) => {
    api.editarLocacionPaseadores(id, { estado: nuevoEstado })
      .then(() => {
        fetchUbicaciones();
      })
      .catch((error) => console.error('Error al cambiar el estado de la ubicación:', error));
  };

  const activarUbicacion = (id) => {
    toggleEstadoUbicacion(id, '1');
  };

  const desactivarUbicacion = (id) => {
    toggleEstadoUbicacion(id, '0');
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
            <a className="navbar-brand">Ubicaciones</a>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por ID de la Ubicación"
                aria-label="Buscar"
                value={filtroIdPaseador}
                onChange={(e) => setFiltroIdPaseador(e.target.value)}
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
              <th>ID Ubicación</th>
              <th>ID Paseador</th>
              <th>Latitud</th>
              <th>Longitud</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {ubicacionesFiltradas.map((ubicacion) => (
              <tr key={ubicacion.id_locacion_paseador}>
                <td>{ubicacion.id_locacion_paseador}</td>
                <td>{ubicacion.id_paseador.id_paseador}</td>
                <td>
                  {ubicacionEditando === ubicacion ? (
                    <input
                      type="text"
                      className="form-control"
                      name="latitud"
                      value={datosEdicion.latitud}
                      onChange={handleInputChangeEditarUbicacion}
                    />
                  ) : (
                    ubicacion.latitud
                  )}
                </td>
                <td>
                  {ubicacionEditando === ubicacion ? (
                    <input
                      type="text"
                      className="form-control"
                      name="longitud"
                      value={datosEdicion.longitud}
                      onChange={handleInputChangeEditarUbicacion}
                    />
                  ) : (
                    ubicacion.longitud
                  )}
                </td>
                <td>
                  {ubicacionEditando === ubicacion ? (
                    <input
                      type="text"
                      className="form-control"
                      name="estado"
                      value={datosEdicion.estado}
                      onChange={handleInputChangeEditarUbicacion}
                    />
                  ) : (
                    ubicacion.estado
                  )}
                </td>
                <td>
                  {ubicacionEditando === ubicacion ? (
                    <>
                      <button onClick={editarUbicacion} className="btn btn-success btn-sm">
                        Guardar
                      </button>
                      <button onClick={cancelarEdicion} className="btn btn-secondary btn-sm">
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => handleEditar(ubicacion)} className="btn btn-warning btn-sm">
                        Editar
                      </button>
                      <button onClick={() => eliminarUbicacion(ubicacion.id_locacion_paseador)} className="btn btn-danger btn-sm">
                        Eliminar
                      </button>
                      <button
                        onClick={() => toggleEstadoUbicacion(ubicacion.id_locacion_paseador, ubicacion.estado === '1' ? '0' : '1')}
                        className={`btn btn-${ubicacion.estado === '1' ? 'danger' : 'success'} btn-sm`}
                      >
                        {ubicacion.estado === '1' ? 'Desactivar' : 'Activar'}
                      </button>
                      <button
                        onClick={() => desactivarUbicacion(ubicacion.id_locacion_paseador)}
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

export default LocacionPaseador;
