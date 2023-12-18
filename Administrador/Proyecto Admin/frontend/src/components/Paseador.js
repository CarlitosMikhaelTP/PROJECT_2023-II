import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

const Paseadores = () => {
  const [paseadores, setPaseadores] = useState([]);
  const [paseadorEditando, setPaseadorEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    id_usuario: '',
    id_categoria: '',
    calificacion: '',
    descripcion: '',
    experiencia: '',
    ubicacion: '',
    tarifa: '',
    saldo: '',
    disponibilidad: '',
    estado: '',
  });
  const [filtroIdPaseador, setFiltroIdPaseador] = useState('');

  const fetchPaseadores = async () => {
    try {
      const data = await api.obtenerPaseadores();
      setPaseadores(data);
    } catch (error) {
      console.error('Error al obtener paseadores:', error);
    }
  };

  useEffect(() => {
    fetchPaseadores();
  }, []);

  const eliminarPaseador = (id) => {
    api.eliminarPaseador(id)
      .then(() => {
        fetchPaseadores();
      })
      .catch((error) => console.error('Error al eliminar paseador:', error));
  };

  const handleEditar = (paseador) => {
    setPaseadorEditando(paseador);
    setDatosEdicion({
      id_usuario: paseador.id_usuario.id_usuario,
      id_categoria: paseador.id_categoria.id_categoria,
      calificacion: paseador.calificacion,
      descripcion: paseador.descripcion,
      experiencia: paseador.experiencia,
      ubicacion: paseador.ubicacion,
      tarifa: paseador.tarifa,
      saldo: paseador.saldo,
      disponibilidad: paseador.disponibilidad,
      estado: paseador.estado,
    });
  };

  const cancelarEdicion = () => {
    setPaseadorEditando(null);
    setDatosEdicion({
      id_usuario: '',
      id_categoria: '',
      calificacion: '',
      descripcion: '',
      experiencia: '',
      ubicacion: '',
      tarifa: '',
      saldo: '',
      disponibilidad: '',
      estado: '',
    });
  };

  const handleInputChangeEditarPaseador = (e) => {
    const { name, value } = e.target;

    setDatosEdicion((prevDatosEdicion) => ({
      ...prevDatosEdicion,
      [name]: value,
    }));
  };

  const editarPaseador = () => {
    if (paseadorEditando) {
      api.editarPaseador(paseadorEditando.id_paseador, datosEdicion)
        .then(() => {
          fetchPaseadores();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar paseador:', error));
    }
  };

  const filtrarPorIdPaseador = (paseadores, filtro) => {
    return paseadores.filter((paseador) =>
      String(paseador.id_paseador).toLowerCase().includes(filtro.toLowerCase())
    );
  };

  const paseadoresFiltrados = filtrarPorIdPaseador(paseadores, filtroIdPaseador);

  const toggleEstadoPaseador = (id, nuevoEstado) => {
    api.editarPaseador(id, { estado: nuevoEstado })
      .then(() => {
        fetchPaseadores();
      })
      .catch((error) => console.error('Error al cambiar el estado del paseador:', error));
  };

  const activarPaseador = (id) => {
    toggleEstadoPaseador(id, '1');
  };

  const desactivarPaseador = (id) => {
    toggleEstadoPaseador(id, '0');
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
            <a className="navbar-brand">Paseadores</a>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por ID del Paseador"
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
              <th>ID Paseador</th>
              <th>ID Usuario</th>
              <th>ID Categoría</th>
              <th>Calificación</th>
              <th>Descripción</th>
              <th>Experiencia</th>
              <th>Ubicación</th>
              <th>Tarifa</th>
              <th>Saldo</th>
              <th>Disponibilidad</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {paseadoresFiltrados.map((paseador) => (
              <tr key={paseador.id_paseador}>
                <td>{paseador.id_paseador}</td>
                <td>
                  {paseadorEditando === paseador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="id_usuario"
                      value={datosEdicion.id_usuario}
                      onChange={handleInputChangeEditarPaseador}
                    />
                  ) : (
                    paseador.id_usuario.id_usuario
                  )}
                </td>
                <td>
                  {paseadorEditando === paseador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="id_categoria"
                      value={datosEdicion.id_categoria}
                      onChange={handleInputChangeEditarPaseador}
                    />
                  ) : (
                    paseador.id_categoria.id_categoria
                  )}
                </td>
                <td>
                  {paseadorEditando === paseador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="calificacion"
                      value={datosEdicion.calificacion}
                      onChange={handleInputChangeEditarPaseador}
                    />
                  ) : (
                    paseador.calificacion
                  )}
                </td>
                <td>
                  {paseadorEditando === paseador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="descripcion"
                      value={datosEdicion.descripcion}
                      onChange={handleInputChangeEditarPaseador}
                    />
                  ) : (
                    paseador.descripcion
                  )}
                </td>
                <td>
                  {paseadorEditando === paseador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="experiencia"
                      value={datosEdicion.experiencia}
                      onChange={handleInputChangeEditarPaseador}
                    />
                  ) : (
                    paseador.experiencia
                  )}
                </td>
                <td>
                  {paseadorEditando === paseador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="ubicacion"
                      value={datosEdicion.ubicacion}
                      onChange={handleInputChangeEditarPaseador}
                    />
                  ) : (
                    paseador.ubicacion
                  )}
                </td>
                <td>
                  {paseadorEditando === paseador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="tarifa"
                      value={datosEdicion.tarifa}
                      onChange={handleInputChangeEditarPaseador}
                    />
                  ) : (
                    paseador.tarifa
                  )}
                </td>
                <td>
                  {paseadorEditando === paseador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="saldo"
                      value={datosEdicion.saldo}
                      onChange={handleInputChangeEditarPaseador}
                    />
                  ) : (
                    paseador.saldo
                  )}
                </td>
                <td>
                  {paseadorEditando === paseador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="disponibilidad"
                      value={datosEdicion.disponibilidad}
                      onChange={handleInputChangeEditarPaseador}
                    />
                  ) : (
                    paseador.disponibilidad
                  )}
                </td>
                <td>
                  {paseadorEditando === paseador ? (
                    <input
                      type="text"
                      className="form-control"
                      name="estado"
                      value={datosEdicion.estado}
                      onChange={handleInputChangeEditarPaseador}
                    />
                  ) : (
                    paseador.estado
                  )}
                </td>
                <td>
                  {paseadorEditando === paseador ? (
                    <>
                      <button onClick={editarPaseador} className="btn btn-success btn-sm">
                        Guardar
                      </button>
                      <button onClick={cancelarEdicion} className="btn btn-secondary btn-sm">
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => handleEditar(paseador)} className="btn btn-warning btn-sm">
                        Editar
                      </button>
                      <button onClick={() => eliminarPaseador(paseador.id_paseador)} className="btn btn-danger btn-sm">
                        Eliminar
                      </button>
                      <button
                        onClick={() => toggleEstadoPaseador(paseador.id_paseador, paseador.estado === '1' ? '0' : '1')}
                        className={`btn btn-${paseador.estado === '1' ? 'danger' : 'success'} btn-sm`}
                      >
                        {paseador.estado === '1' ? 'Desactivar' : 'Activar'}
                      </button>
                      <button
                        onClick={() => desactivarPaseador(paseador.id_paseador)}
                        className="btn btn-danger btn-sm"
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

export default Paseadores;
