import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

const TipoUsuarios = () => {
  const [tipoUsuarios, setTipoUsuarios] = useState([]);
  const [tipoUsuarioEditando, setTipoUsuarioEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    nombre_tipo_usuario: '',
    descripcion: '',
    estado: '',
  });
  const [busquedaNombre, setBusquedaNombre] = useState('');
  const [tipoUsuariosFiltrados, setTipoUsuariosFiltrados] = useState([]);

  const fetchTipoUsuarios = async () => {
    try {
      const data = await api.obtenerTipoUsuarios();
      setTipoUsuarios(data);
      filtrarTipoUsuarios(data, busquedaNombre);
    } catch (error) {
      console.error('Error al obtener tipos de usuario:', error);
    }
  };

  useEffect(() => {
    fetchTipoUsuarios();
  }, [busquedaNombre]);

  const eliminarTipoUsuario = (id) => {
    api.eliminarTipoUsuario(id)
      .then(() => {
        fetchTipoUsuarios();
      })
      .catch((error) => console.error('Error al eliminar tipo de usuario:', error));
  };

  const handleEditar = (tipoUsuario) => {
    setTipoUsuarioEditando(tipoUsuario);
    setDatosEdicion({
      nombre_tipo_usuario: tipoUsuario.nombre_tipo_usuario,
      descripcion: tipoUsuario.descripcion,
      estado: tipoUsuario.estado,
    });
  };

  const cancelarEdicion = () => {
    setTipoUsuarioEditando(null);
    setDatosEdicion({
      nombre_tipo_usuario: '',
      descripcion: '',
      estado: '',
    });
  };

  const handleInputChangeEditarTipoUsuario = (e) => {
    const { name, value } = e.target;

    setDatosEdicion((prevDatosEdicion) => ({
      ...prevDatosEdicion,
      [name]: value,
    }));
  };

  const editarTipoUsuario = () => {
    if (tipoUsuarioEditando) {
      api.editarTipoUsuario(tipoUsuarioEditando.id_tipo_usuario, datosEdicion)
        .then(() => {
          fetchTipoUsuarios();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar tipo de usuario:', error));
    }
  };

  const filtrarTipoUsuarios = (tipoUsuarios, busquedaNombre) => {
    const tipoUsuariosFiltrados = tipoUsuarios.filter((tipoUsuario) =>
      tipoUsuario.nombre_tipo_usuario.toLowerCase().includes(busquedaNombre.toLowerCase())
    );
    setTipoUsuariosFiltrados(tipoUsuariosFiltrados);
  };

  const toggleEstadoTipoUsuario = (id, nuevoEstado) => {
    api.editarTipoUsuario(id, { estado: nuevoEstado })
      .then(() => {
        fetchTipoUsuarios();
      })
      .catch((error) => console.error('Error al cambiar el estado del tipo de usuario:', error));
  };

  const desactivarTipoUsuario = (id) => {
    toggleEstadoTipoUsuario(id, '0'); 
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
            <a className="navbar-brand">Tipos de Usuario</a>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por Nombre de Tipo Usuario"
                aria-label="Buscar"
                value={busquedaNombre}
                onChange={(e) => setBusquedaNombre(e.target.value)}
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
              <th>Nombre Tipo Usuario</th>
              <th>Descripción</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {tipoUsuariosFiltrados.map((tipoUsuario) => (
              <tr key={tipoUsuario.id_tipo_usuario}>
                <td>{tipoUsuario.id_tipo_usuario}</td>
                <td>
                  {tipoUsuarioEditando === tipoUsuario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="nombre_tipo_usuario"
                      value={datosEdicion.nombre_tipo_usuario}
                      onChange={handleInputChangeEditarTipoUsuario}
                    />
                  ) : (
                    tipoUsuario.nombre_tipo_usuario
                  )}
                </td>
                <td>
                  {tipoUsuarioEditando === tipoUsuario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="descripcion"
                      value={datosEdicion.descripcion}
                      onChange={handleInputChangeEditarTipoUsuario}
                    />
                  ) : (
                    tipoUsuario.descripcion
                  )}
                </td>
                <td>
                  {tipoUsuarioEditando === tipoUsuario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="estado"
                      value={datosEdicion.estado}
                      onChange={handleInputChangeEditarTipoUsuario}
                    />
                  ) : (
                    tipoUsuario.estado
                  )}
                </td>
                <td>
                  {tipoUsuarioEditando === tipoUsuario ? (
                    <>
                      <button onClick={editarTipoUsuario} className="btn btn-success btn-sm">
                        Guardar
                      </button>
                      <button onClick={cancelarEdicion} className="btn btn-secondary btn-sm">
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => handleEditar(tipoUsuario)} className="btn btn-warning btn-sm">
                        Editar
                      </button>
                      <button onClick={() => eliminarTipoUsuario(tipoUsuario.id_tipo_usuario)} className="btn btn-danger btn-sm">
                        Eliminar
                      </button>
                      <button
                        onClick={() => toggleEstadoTipoUsuario(tipoUsuario.id_tipo_usuario, tipoUsuario.estado === '1' ? '0' : '1')}
                        className={`btn btn-${tipoUsuario.estado === '1' ? 'danger' : 'success'} btn-sm`}
                      >
                        {tipoUsuario.estado === '1' ? 'Desactivar' : 'Activar'}
                      </button>
                      <button
                        onClick={() => desactivarTipoUsuario(tipoUsuario.id_tipo_usuario)} 
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

export default TipoUsuarios;
