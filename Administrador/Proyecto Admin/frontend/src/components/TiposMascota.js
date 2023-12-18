import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

const TiposMascota = () => {
  const [tiposMascota, setTiposMascota] = useState([]);
  const [tipoMascotaEditando, setTipoMascotaEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    nombre: '',
    estado: '',
  });
  const [filtroNombre, setFiltroNombre] = useState('');
  const [tiposMascotaFiltrados, setTiposMascotaFiltrados] = useState([]);

  const fetchTiposMascota = async () => {
    try {
      const data = await api.obtenerTiposMascota();
      setTiposMascota(data);
      setTiposMascotaFiltrados(filtrarPorNombre(data, filtroNombre));
    } catch (error) {
      console.error('Error al obtener tipos de mascota:', error);
    }
  };

  useEffect(() => {
    fetchTiposMascota();
  }, [filtroNombre]);

  const eliminarTipoMascota = (id) => {
    api.eliminarTipoMascota(id)
      .then(() => {
        fetchTiposMascota();
      })
      .catch((error) => console.error('Error al eliminar tipo de mascota:', error));
  };

  const handleEditar = (tipoMascota) => {
    setTipoMascotaEditando(tipoMascota);
    setDatosEdicion({
      nombre: tipoMascota.nombre,
      estado: tipoMascota.estado,
    });
  };

  const cancelarEdicion = () => {
    setTipoMascotaEditando(null);
    setDatosEdicion({
      nombre: '',
      estado: '',
    });
  };

  const handleInputChangeEditarTipoMascota = (e) => {
    const { name, value } = e.target;

    setDatosEdicion((prevDatosEdicion) => ({
      ...prevDatosEdicion,
      [name]: value,
    }));
  };

  const editarTipoMascota = () => {
    if (tipoMascotaEditando) {
      api.editarTipoMascota(tipoMascotaEditando.id_tipo_mascota, datosEdicion)
        .then(() => {
          fetchTiposMascota();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar tipo de mascota:', error));
    }
  };

  const toggleEstadoTipoMascota = (id, nuevoEstado) => {
    api.editarTipoMascota(id, { estado: nuevoEstado })
      .then(() => {
        fetchTiposMascota();
      })
      .catch((error) => console.error('Error al cambiar el estado del tipo de mascota:', error));
  };

  const activarTipoMascota = (id) => {
    toggleEstadoTipoMascota(id, '1');
  };

  const desactivarTipoMascota = (id) => {
    toggleEstadoTipoMascota(id, '0');
  };

  const filtrarPorNombre = (tiposMascota, filtro) => {
    return tiposMascota.filter((tipoMascota) =>
      tipoMascota.nombre.toLowerCase().includes(filtro.toLowerCase())
    );
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
            <a className="navbar-brand">Tipos de Mascota</a>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por Nombre"
                aria-label="Buscar"
                value={filtroNombre}
                onChange={(e) => setFiltroNombre(e.target.value)}
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
              <th>ID</th>
              <th>Nombre</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {tiposMascotaFiltrados.map((tipoMascota) => (
              <tr key={tipoMascota.id_tipo_mascota}>
                <td>{tipoMascota.id_tipo_mascota}</td>
                <td>
                  {tipoMascotaEditando === tipoMascota ? (
                    <input
                      type="text"
                      className="form-control"
                      name="nombre"
                      value={datosEdicion.nombre}
                      onChange={handleInputChangeEditarTipoMascota}
                    />
                  ) : (
                    tipoMascota.nombre
                  )}
                </td>
                <td>
                  {tipoMascotaEditando === tipoMascota ? (
                    <input
                      type="text"
                      className="form-control"
                      name="estado"
                      value={datosEdicion.estado}
                      onChange={handleInputChangeEditarTipoMascota}
                    />
                  ) : (
                    tipoMascota.estado
                  )}
                </td>
                <td>
                  {tipoMascotaEditando === tipoMascota ? (
                    <>
                      <button onClick={editarTipoMascota} className="btn btn-success btn-sm">
                        Guardar
                      </button>
                      <button onClick={cancelarEdicion} className="btn btn-secondary btn-sm">
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => handleEditar(tipoMascota)} className="btn btn-warning btn-sm">
                        Editar
                      </button>
                      <button onClick={() => eliminarTipoMascota(tipoMascota.id_tipo_mascota)} className="btn btn-danger btn-sm">
                        Eliminar
                      </button>
                      <button
                        onClick={() => tipoMascota.estado === '1' ? desactivarTipoMascota(tipoMascota.id_tipo_mascota) : activarTipoMascota(tipoMascota.id_tipo_mascota)}
                        className={`btn btn-${tipoMascota.estado === '1' ? 'danger' : 'success'} btn-sm`}
                      >
                        {tipoMascota.estado === '1' ? 'Desactivar' : 'Activar'}
                      </button>
                      <button
                        onClick={() => desactivarTipoMascota(tipoMascota.id_tipo_mascota)}
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

export default TiposMascota;
