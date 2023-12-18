import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

const TiposTransaccion = () => {
  const [tiposTransaccion, setTiposTransaccion] = useState([]);
  const [tipoTransaccionEditando, setTipoTransaccionEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    nombre_tipo: '',
    descripcion: '',
    estado: '',
  });
  const [filtroNombreTipo, setFiltroNombreTipo] = useState('');
  const [tiposTransaccionFiltrados, setTiposTransaccionFiltrados] = useState([]);

  const fetchTiposTransaccion = async () => {
    try {
      const data = await api.obtenerTiposTransaccion();
      setTiposTransaccion(data);
      setTiposTransaccionFiltrados(filtrarPorNombreTipo(data, filtroNombreTipo));
    } catch (error) {
      console.error('Error al obtener tipos de transacción:', error);
    }
  };

  useEffect(() => {
    fetchTiposTransaccion();
  }, [filtroNombreTipo]);

  const eliminarTipoTransaccion = (id) => {
    api.eliminarTipoTransaccion(id)
      .then(() => {
        fetchTiposTransaccion();
      })
      .catch((error) => console.error('Error al eliminar tipo de transacción:', error));
  };

  const handleEditar = (tipoTransaccion) => {
    setTipoTransaccionEditando(tipoTransaccion);
    setDatosEdicion({
      nombre_tipo: tipoTransaccion.nombre_tipo,
      descripcion: tipoTransaccion.descripcion,
      estado: tipoTransaccion.estado,
    });
  };

  const cancelarEdicion = () => {
    setTipoTransaccionEditando(null);
    setDatosEdicion({
      nombre_tipo: '',
      descripcion: '',
      estado: '',
    });
  };

  const handleInputChangeEditarTipoTransaccion = (e) => {
    const { name, value } = e.target;

    setDatosEdicion((prevDatosEdicion) => ({
      ...prevDatosEdicion,
      [name]: value,
    }));
  };

  const editarTipoTransaccion = () => {
    if (tipoTransaccionEditando) {
      api.editarTipoTransaccion(tipoTransaccionEditando.id_tipo_transaccion, datosEdicion)
        .then(() => {
          fetchTiposTransaccion();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar tipo de transacción:', error));
    }
  };

  const filtrarPorNombreTipo = (tiposTransaccion, filtro) => {
    return tiposTransaccion.filter((tipoTransaccion) =>
      tipoTransaccion.nombre_tipo.toLowerCase().includes(filtro.toLowerCase())
    );
  };

  const toggleEstadoTipoTransaccion = (id, nuevoEstado) => {
    api.editarTipoTransaccion(id, { estado: nuevoEstado })
      .then(() => {
        fetchTiposTransaccion();
      })
      .catch((error) => console.error('Error al cambiar el estado del tipo de transacción:', error));
  };

  const activarTipoTransaccion = (id) => {
    toggleEstadoTipoTransaccion(id, '1');
  };

  const desactivarTipoTransaccion = (id) => {
    toggleEstadoTipoTransaccion(id, '0');
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
            <a className="navbar-brand">Tipos de Transacción</a>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por Nombre Tipo"
                aria-label="Buscar"
                value={filtroNombreTipo}
                onChange={(e) => setFiltroNombreTipo(e.target.value)}
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
              <th>Nombre Tipo</th>
              <th>Descripción</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {tiposTransaccionFiltrados.map((tipoTransaccion) => (
              <tr key={tipoTransaccion.id_tipo_transaccion}>
                <td>{tipoTransaccion.id_tipo_transaccion}</td>
                <td>
                  {tipoTransaccionEditando === tipoTransaccion ? (
                    <input
                      type="text"
                      className="form-control"
                      name="nombre_tipo"
                      value={datosEdicion.nombre_tipo}
                      onChange={handleInputChangeEditarTipoTransaccion}
                    />
                  ) : (
                    tipoTransaccion.nombre_tipo
                  )}
                </td>
                <td>
                  {tipoTransaccionEditando === tipoTransaccion ? (
                    <input
                      type="text"
                      className="form-control"
                      name="descripcion"
                      value={datosEdicion.descripcion}
                      onChange={handleInputChangeEditarTipoTransaccion}
                    />
                  ) : (
                    tipoTransaccion.descripcion
                  )}
                </td>
                <td>
                  {tipoTransaccionEditando === tipoTransaccion ? (
                    <input
                      type="text"
                      className="form-control"
                      name="estado"
                      value={datosEdicion.estado}
                      onChange={handleInputChangeEditarTipoTransaccion}
                    />
                  ) : (
                    tipoTransaccion.estado
                  )}
                </td>
                <td>
                  {tipoTransaccionEditando === tipoTransaccion ? (
                    <>
                      <button onClick={editarTipoTransaccion} className="btn btn-success btn-sm">
                        Guardar
                      </button>
                      <button onClick={cancelarEdicion} className="btn btn-secondary btn-sm">
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => handleEditar(tipoTransaccion)} className="btn btn-warning btn-sm">
                        Editar
                      </button>
                      <button onClick={() => eliminarTipoTransaccion(tipoTransaccion.id_tipo_transaccion)} className="btn btn-danger btn-sm">
                        Eliminar
                      </button>
                      <button
                        onClick={() => toggleEstadoTipoTransaccion(tipoTransaccion.id_tipo_transaccion, tipoTransaccion.estado === '1' ? '0' : '1')}
                        className={`btn btn-${tipoTransaccion.estado === '1' ? 'danger' : 'success'} btn-sm`}
                      >
                        {tipoTransaccion.estado === '1' ? 'Desactivar' : 'Activar'}
                      </button>
                      <button
                        onClick={() => desactivarTipoTransaccion(tipoTransaccion.id_tipo_transaccion)}
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

export default TiposTransaccion;
