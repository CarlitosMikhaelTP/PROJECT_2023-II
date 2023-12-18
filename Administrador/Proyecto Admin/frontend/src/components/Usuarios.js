import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

const Usuarios = () => {
  const [usuarios, setUsuarios] = useState([]);
  const [usuarioEditando, setUsuarioEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    id_tipo_usuario: '',
    nombres: '',
    apellidos: '',
    apodo: '',
    email: '',
    direccion: '',
    edad: '',
    celular: '',
    dni: '',
    contraseña: '',
    estado: '',
  });
  const [busqueda, setBusqueda] = useState('');
  const [usuariosFiltrados, setUsuariosFiltrados] = useState([]);

  const fetchUsuarios = async () => {
    try {
      const data = await api.obtenerUsuarios();
      setUsuarios(data);
      filtrarUsuarios(data, busqueda);
    } catch (error) {
      console.error('Error al obtener usuarios:', error);
    }
  };

  useEffect(() => {
    fetchUsuarios();
  }, [busqueda]);

  const eliminarUsuario = (id) => {
    api.eliminarUsuario(id)
      .then(() => {
        fetchUsuarios();
      })
      .catch((error) => console.error('Error al eliminar usuario:', error));
  };

  const handleEditar = (usuario) => {
    setUsuarioEditando(usuario);
    setDatosEdicion({
      id_tipo_usuario: usuario.id_tipo_usuario,
      nombres: usuario.nombres,
      apellidos: usuario.apellidos,
      apodo: usuario.apodo,
      email: usuario.email,
      direccion: usuario.direccion,
      edad: usuario.edad,
      celular: usuario.celular,
      dni: usuario.dni,
      contraseña: '',
      estado: usuario.estado,
    });
  };

  const cancelarEdicion = () => {
    setUsuarioEditando(null);
    setDatosEdicion({
      id_tipo_usuario: '',
      nombres: '',
      apellidos: '',
      apodo: '',
      email: '',
      direccion: '',
      edad: '',
      celular: '',
      dni: '',
      contraseña: '',
      estado: '',
    });
  };

  const handleInputChangeEditarUsuario = (e) => {
    const { name, value } = e.target;

    setDatosEdicion((prevDatosEdicion) => ({
      ...prevDatosEdicion,
      [name]: name === 'password' ? value.trim() : value,
    }));
  };

  const editarUsuario = () => {
    if (usuarioEditando) {
      const datosEditar = { ...datosEdicion };

      if (typeof datosEdicion.password !== 'undefined' && datosEdicion.password.trim() === '') {
        delete datosEditar.password;
      }

      api.editarUsuario(usuarioEditando.id, datosEditar)
        .then(() => {
          fetchUsuarios();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar usuario:', error));
    }
  };

  const filtrarUsuarios = (usuarios, busqueda) => {
    const usuariosFiltrados = usuarios.filter((usuario) =>
      usuario.email.toLowerCase().includes(busqueda.toLowerCase())
    );
    setUsuariosFiltrados(usuariosFiltrados);
  };

  const toggleEstadoUsuario = (id, nuevoEstado) => {
    api.editarUsuario(id, { estado: nuevoEstado })
      .then(() => {
        fetchUsuarios();
      })
      .catch((error) => console.error('Error al cambiar el estado del usuario:', error));
  };

  const desactivarUsuario = (id) => {
    toggleEstadoUsuario(id, '0'); 
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
            <a className="navbar-brand">Usuarios</a>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por Email"
                aria-label="Buscar"
                value={busqueda}
                onChange={(e) => setBusqueda(e.target.value)}
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
              <th>Tipo de Usuario</th>
              <th>Nombres</th>
              <th>Apellidos</th>
              <th>Apodo</th>
              <th>Email</th>
              <th>Dirección</th>
              <th>Edad</th>
              <th>Celular</th>
              <th>DNI</th>
              <th>Contraseña</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {usuariosFiltrados.map((usuario) => (
              <tr key={usuario.id}>
                <td>{usuario.id}</td>
                <td>
                  {usuarioEditando === usuario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="id_tipo_usuario"
                      value={datosEdicion.id_tipo_usuario}
                      onChange={handleInputChangeEditarUsuario}
                    />
                  ) : (
                    usuario.id_tipo_usuario
                  )}
                </td>
                <td>
                  {usuarioEditando === usuario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="nombres"
                      value={datosEdicion.nombres}
                      onChange={handleInputChangeEditarUsuario}
                    />
                  ) : (
                    usuario.nombres
                  )}
                </td>
                <td>
                  {usuarioEditando === usuario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="apellidos"
                      value={datosEdicion.apellidos}
                      onChange={handleInputChangeEditarUsuario}
                    />
                  ) : (
                    usuario.apellidos
                  )}
                </td>
                <td>
                  {usuarioEditando === usuario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="apodo"
                      value={datosEdicion.apodo}
                      onChange={handleInputChangeEditarUsuario}
                    />
                  ) : (
                    usuario.apodo
                  )}
                </td>
                <td>
                  {usuarioEditando === usuario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="email"
                      value={datosEdicion.email}
                      onChange={handleInputChangeEditarUsuario}
                    />
                  ) : (
                    usuario.email
                  )}
                </td>
                <td>
                  {usuarioEditando === usuario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="direccion"
                      value={datosEdicion.direccion}
                      onChange={handleInputChangeEditarUsuario}
                    />
                  ) : (
                    usuario.direccion
                  )}
                </td>
                <td>
                  {usuarioEditando === usuario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="edad"
                      value={datosEdicion.edad}
                      onChange={handleInputChangeEditarUsuario}
                    />
                  ) : (
                    usuario.edad
                  )}
                </td>
                <td>
                  {usuarioEditando === usuario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="celular"
                      value={datosEdicion.celular}
                      onChange={handleInputChangeEditarUsuario}
                    />
                  ) : (
                    usuario.celular
                  )}
                </td>
                <td>
                  {usuarioEditando === usuario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="dni"
                      value={datosEdicion.dni}
                      onChange={handleInputChangeEditarUsuario}
                    />
                  ) : (
                    usuario.dni
                  )}
                </td>
                <td>
                  {usuarioEditando === usuario ? (
                    <input
                      type="password"
                      className="form-control"
                      name="contraseña"
                      value={datosEdicion.contraseña}
                      onChange={handleInputChangeEditarUsuario}
                    />
                  ) : (
                    usuario.password
                  )}
                </td>
                <td>
                  {usuarioEditando === usuario ? (
                    <input
                      type="text"
                      className="form-control"
                      name="estado"
                      value={datosEdicion.estado}
                      onChange={handleInputChangeEditarUsuario}
                    />
                  ) : (
                    usuario.estado
                  )}
                </td>
                <td>
                  {usuarioEditando === usuario ? (
                    <>
                      <button onClick={editarUsuario} className="btn btn-success btn-sm">
                        Guardar
                      </button>
                      <button onClick={cancelarEdicion} className="btn btn-secondary btn-sm">
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => handleEditar(usuario)} className="btn btn-warning btn-sm">
                        Editar
                      </button>
                      <button onClick={() => eliminarUsuario(usuario.id)} className="btn btn-danger btn-sm">
                        Eliminar
                      </button>
                      <button
                        onClick={() => toggleEstadoUsuario(usuario.id, usuario.estado === '1' ? '0' : '1')}
                        className={`btn btn-${usuario.estado === '1' ? 'danger' : 'success'} btn-sm`}
                      >
                        {usuario.estado === '1' ? 'Desactivar' : 'Activar'}
                      </button>
                      <button
                        onClick={() => desactivarUsuario(usuario.id)} 
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

export default Usuarios;
