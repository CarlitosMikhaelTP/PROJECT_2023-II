import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

// Aqui se ponen las funciones de api.js como editar eliminar mostrar y filtrar

const Administrador = () => {
  const [administradores, setAdministradores] = useState([]);
  const [administradorEditando, setAdministradorEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    nombres: '',
    apellidos: '',
    nombre_usuario: '',
    email: '',
    edad: '',
    numero: '',
    dni: '',
    contraseña: '',
  });
  const [filtroEmail, setFiltroEmail] = useState('');
  const [administradoresFiltrados, setAdministradoresFiltrados] = useState([]);

  const fetchAdministradores = async () => {
    try {
      const data = await api.obtenerAdministradores();
      setAdministradores(data);
      setAdministradoresFiltrados(filtrarPorEmail(data, filtroEmail));
    } catch (error) {
      console.error('Error al obtener administradores:', error);
    }
  };

  useEffect(() => {
    fetchAdministradores();
  }, [filtroEmail]);

  const eliminarAdministrador = (id) => {
    api.eliminarAdministrador(id)
      .then(() => {
        fetchAdministradores();
      })
      .catch((error) => console.error('Error al eliminar administrador:', error));
  };

  const handleEditar = (administrador) => {
    setAdministradorEditando(administrador);
    setDatosEdicion({
      nombres: administrador.nombres,
      apellidos: administrador.apellidos,
      nombre_usuario: administrador.nombre_usuario,
      email: administrador.email,
      edad: administrador.edad,
      numero: administrador.numero,
      dni: administrador.dni,
      contraseña: administrador.contraseña,
    });
  };

  const cancelarEdicion = () => {
    setAdministradorEditando(null);
    setDatosEdicion({
      nombres: '',
      apellidos: '',
      nombre_usuario: '',
      email: '',
      edad: '',
      numero: '',
      dni: '',
      contraseña: '',
    });
  };

  const handleInputChangeEditarAdministrador = (e) => {
    const { name, value } = e.target;

    setDatosEdicion((prevDatosEdicion) => ({
      ...prevDatosEdicion,
      [name]: value,
    }));
  };

  const editarAdministrador = () => {
    if (administradorEditando) {
      api.editarAdministrador(administradorEditando.id, datosEdicion)
        .then(() => {
          fetchAdministradores();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar administrador:', error));
    }
  };

  const filtrarPorEmail = (administradores, filtro) => {
    return administradores.filter((admin) =>
      admin.email.toLowerCase().includes(filtro.toLowerCase())
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
            <a className="navbar-brand">Administradores</a>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por Email"
                aria-label="Buscar"
                value={filtroEmail}
                onChange={(e) => setFiltroEmail(e.target.value)}
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
              <th>Nombres</th>
              <th>Apellidos</th>
              <th>Nombre de Usuario</th>
              <th>Email</th>
              <th>Edad</th>
              <th>Número</th>
              <th>DNI</th>
              <th>Contraseña</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {administradoresFiltrados.map((administrador) => (
              <tr key={administrador.id}>
                <td>{administrador.id}</td>
                <td>
                  {administradorEditando === administrador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="nombres"
                      value={datosEdicion.nombres}
                      onChange={handleInputChangeEditarAdministrador}
                    />
                  ) : (
                    administrador.nombres
                  )}
                </td>
                <td>
                  {administradorEditando === administrador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="apellidos"
                      value={datosEdicion.apellidos}
                      onChange={handleInputChangeEditarAdministrador}
                    />
                  ) : (
                    administrador.apellidos
                  )}
                </td>
                <td>
                  {administradorEditando === administrador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="nombre_usuario"
                      value={datosEdicion.nombre_usuario}
                      onChange={handleInputChangeEditarAdministrador}
                    />
                  ) : (
                    administrador.nombre_usuario
                  )}
                </td>
                <td>
                  {administradorEditando === administrador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="email"
                      value={datosEdicion.email}
                      onChange={handleInputChangeEditarAdministrador}
                    />
                  ) : (
                    administrador.email
                  )}
                </td>
                <td>
                  {administradorEditando === administrador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="edad"
                      value={datosEdicion.edad}
                      onChange={handleInputChangeEditarAdministrador}
                    />
                  ) : (
                    administrador.edad
                  )}
                </td>
                <td>
                  {administradorEditando === administrador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="numero"
                      value={datosEdicion.numero}
                      onChange={handleInputChangeEditarAdministrador}
                    />
                  ) : (
                    administrador.numero
                  )}
                </td>
                <td>
                  {administradorEditando === administrador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="dni"
                      value={datosEdicion.dni}
                      onChange={handleInputChangeEditarAdministrador}
                    />
                  ) : (
                    administrador.dni
                  )}
                </td>
                <td>
                  {administradorEditando === administrador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="contraseña"
                      value={datosEdicion.contraseña}
                      onChange={handleInputChangeEditarAdministrador}
                    />
                  ) : (
                    administrador.contraseña
                  )}
                </td>
                <td>
                  {administradorEditando === administrador ? (
                    <>
                      <button onClick={editarAdministrador} className="btn btn-success btn-sm">
                        Guardar
                      </button>
                      <button onClick={cancelarEdicion} className="btn btn-secondary btn-sm">
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <button onClick={() => handleEditar(administrador)} className="btn btn-warning btn-sm">
                      Editar
                    </button>
                  )}
                  <button onClick={() => eliminarAdministrador(administrador.id)} className="btn btn-danger btn-sm">
                    Eliminar
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Administrador;
