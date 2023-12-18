import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

const LocacionPropietario = () => {
  const [ubicaciones, setUbicaciones] = useState([]);
  const [ubicacionEditando, setUbicacionEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    id_propietario: '',
    latitud: '',
    longitud: '',
    estado: '',
  });
  const [filtroIdPropietario, setFiltroIdPropietario] = useState('');

  const fetchUbicaciones = async () => {
    try {
      const data = await api.obtenerLocacionPropietarios();
      setUbicaciones(data);
    } catch (error) {
      console.error('Error al obtener ubicaciones:', error);
    }
  };

  useEffect(() => {
    fetchUbicaciones();
  }, []);

  const eliminarUbicacion = (id) => {
    api.eliminarLocacionPropietarios(id)
      .then(() => {
        fetchUbicaciones();
      })
      .catch((error) => console.error('Error al eliminar ubicación:', error));
  };

  const handleEditar = (ubicacion) => {
    setUbicacionEditando(ubicacion);
    setDatosEdicion({
      id_propietario: ubicacion.id_propietario.id_propietario,
      latitud: ubicacion.latitud,
      longitud: ubicacion.longitud,
      estado: ubicacion.estado,
    });
  };

  const cancelarEdicion = () => {
    setUbicacionEditando(null);
    setDatosEdicion({
      id_propietario: '',
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
      api.editarLocacionPropietarios(ubicacionEditando.id_locacion_propietario, datosEdicion)
        .then(() => {
          fetchUbicaciones();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar ubicación:', error));
    }
  };

  const filtrarPorIdPropietario = (ubicaciones, filtro) => {
    return ubicaciones.filter((ubicacion) =>
      String(ubicacion.id_locacion_propietario).toLowerCase().includes(filtro.toLowerCase())
    );
  };

  const ubicacionesFiltradas = filtrarPorIdPropietario(ubicaciones, filtroIdPropietario);

  const toggleEstadoUbicacion = (id, nuevoEstado) => {
    api.editarLocacionPropietarios(id, { estado: nuevoEstado })
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
            <a className="navbar-brand">Ubicaciones Propietarios</a>
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
              <th>ID Ubicación</th>
              <th>ID Propietario</th>
              <th>Latitud</th>
              <th>Longitud</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {ubicacionesFiltradas.map((ubicacion) => (
              <tr key={ubicacion.id_locacion_propietario}>
                <td>{ubicacion.id_locacion_propietario}</td>
                <td>{ubicacion.id_propietario.id_propietario}</td>
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
                      <button onClick={() => eliminarUbicacion(ubicacion.id_locacion_propietario)} className="btn btn-danger btn-sm">
                        Eliminar
                      </button>
                      <button
                        onClick={() => toggleEstadoUbicacion(ubicacion.id_locacion_propietario, ubicacion.estado === '1' ? '0' : '1')}
                        className={`btn btn-${ubicacion.estado === '1' ? 'danger' : 'success'} btn-sm`}
                      >
                        {ubicacion.estado === '1' ? 'Desactivar' : 'Activar'}
                      </button>
                      <button
                        onClick={() => desactivarUbicacion(ubicacion.id_locacion_propietario)}
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

export default LocacionPropietario;
