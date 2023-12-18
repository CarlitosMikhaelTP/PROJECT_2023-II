import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

const EstadosTransaccion = () => {
  const [estadosTransaccion, setEstadosTransaccion] = useState([]);
  const [estadoEditando, setEstadoEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    nombre_estado: '',
    descripcion: '',
    estado: '',
  });
  const [filtroNombreEstado, setFiltroNombreEstado] = useState('');
  const [estadosTransaccionFiltrados, setEstadosTransaccionFiltrados] = useState([]);

  const fetchEstadosTransaccion = async () => {
    try {
      const data = await api.obtenerEstadosTransaccion();
      setEstadosTransaccion(data);
      setEstadosTransaccionFiltrados(filtrarPorNombreEstado(data, filtroNombreEstado));
    } catch (error) {
      console.error('Error al obtener estados de transacción:', error);
    }
  };

  useEffect(() => {
    fetchEstadosTransaccion();
  }, [filtroNombreEstado]);

  const eliminarEstadoTransaccion = (id) => {
    api.eliminarEstadoTransaccion(id)
      .then(() => {
        fetchEstadosTransaccion();
      })
      .catch((error) => console.error('Error al eliminar estado de transacción:', error));
  };

  const handleEditar = (estado) => {
    setEstadoEditando(estado);
    setDatosEdicion({
      nombre_estado: estado.nombre_estado,
      descripcion: estado.descripcion,
      estado: estado.estado,
    });
  };

  const cancelarEdicion = () => {
    setEstadoEditando(null);
    setDatosEdicion({
      nombre_estado: '',
      descripcion: '',
      estado: '',
    });
  };

  const handleInputChangeEditarEstadoTransaccion = (e) => {
    const { name, value } = e.target;

    setDatosEdicion((prevDatosEdicion) => ({
      ...prevDatosEdicion,
      [name]: value,
    }));
  };

  const editarEstadoTransaccion = () => {
    if (estadoEditando) {
      api.editarEstadoTransaccion(estadoEditando.id_estado_transaccion, datosEdicion)
        .then(() => {
          fetchEstadosTransaccion();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar estado de transacción:', error));
    }
  };

  const filtrarPorNombreEstado = (estadosTransaccion, filtro) => {
    return estadosTransaccion.filter((estadoTransaccion) =>
      estadoTransaccion.nombre_estado.toLowerCase().includes(filtro.toLowerCase())
    );
  };

  const toggleEstadoTransaccion = (id, nuevoEstado) => {
    api.editarEstadoTransaccion(id, { estado: nuevoEstado })
      .then(() => {
        fetchEstadosTransaccion();
      })
      .catch((error) => console.error('Error al cambiar el estado del estado de transacción:', error));
  };

  const activarEstadoTransaccion = (id) => {
    toggleEstadoTransaccion(id, '1');
  };

  const desactivarEstadoTransaccion = (id) => {
    toggleEstadoTransaccion(id, '0');
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
            <a className="navbar-brand">Estados de Transacción</a>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por Nombre Estado"
                aria-label="Buscar"
                value={filtroNombreEstado}
                onChange={(e) => setFiltroNombreEstado(e.target.value)}
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
              <th>ID Estado Transacción</th>
              <th>Nombre Estado</th>
              <th>Descripción</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {estadosTransaccionFiltrados.map((estado) => (
              <tr key={estado.id_estado_transaccion}>
                <td>{estado.id_estado_transaccion}</td>
                <td>
                  {estadoEditando === estado ? (
                    <input
                      type="text"
                      className="form-control"
                      name="nombre_estado"
                      value={datosEdicion.nombre_estado}
                      onChange={handleInputChangeEditarEstadoTransaccion}
                    />
                  ) : (
                    estado.nombre_estado
                  )}
                </td>
                <td>
                  {estadoEditando === estado ? (
                    <input
                      type="text"
                      className="form-control"
                      name="descripcion"
                      value={datosEdicion.descripcion}
                      onChange={handleInputChangeEditarEstadoTransaccion}
                    />
                  ) : (
                    estado.descripcion
                  )}
                </td>
                <td>
                  {estadoEditando === estado ? (
                    <input
                      type="text"
                      className="form-control"
                      name="estado"
                      value={datosEdicion.estado}
                      onChange={handleInputChangeEditarEstadoTransaccion}
                    />
                  ) : (
                    estado.estado
                  )}
                </td>
                <td>
                  {estadoEditando === estado ? (
                    <>
                      <button onClick={editarEstadoTransaccion} className="btn btn-success btn-sm">
                        Guardar
                      </button>
                      <button onClick={cancelarEdicion} className="btn btn-secondary btn-sm">
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => handleEditar(estado)} className="btn btn-warning btn-sm">
                        Editar
                      </button>
                      <button onClick={() => eliminarEstadoTransaccion(estado.id_estado_transaccion)} className="btn btn-danger btn-sm">
                        Eliminar
                      </button>
                      <button
                        onClick={() => toggleEstadoTransaccion(estado.id_estado_transaccion, estado.estado === '1' ? '0' : '1')}
                        className={`btn btn-${estado.estado === '1' ? 'danger' : 'success'} btn-sm`}
                      >
                        {estado.estado === '1' ? 'Desactivar' : 'Activar'}
                      </button>
                      <button
                        onClick={() => desactivarEstadoTransaccion(estado.id_estado_transaccion)}
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

export default EstadosTransaccion;
