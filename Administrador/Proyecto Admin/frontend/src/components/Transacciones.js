import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

const Transacciones = () => {
  const [transacciones, setTransacciones] = useState([]);
  const [transaccionEditando, setTransaccionEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    id_paseador: '',
    id_propietario: '',
    id_tipo_transaccion: '',
    id_estado_transaccion: '',
    monto: '',
    estado: '',
  });
  const [filtroID, setFiltroID] = useState('');
  const [transaccionesFiltradas, setTransaccionesFiltradas] = useState([]);

  const fetchTransacciones = async () => {
    try {
      const data = await api.obtenerTransacciones();
      setTransacciones(data);
      setTransaccionesFiltradas(filtrarPorID(data, filtroID));
    } catch (error) {
      console.error('Error al obtener transacciones:', error);
    }
  };

  useEffect(() => {
    fetchTransacciones();
  }, [filtroID]);

  const eliminarTransaccion = (id) => {
    api.eliminarTransaccion(id)
      .then(() => {
        fetchTransacciones();
      })
      .catch((error) => console.error('Error al eliminar transacción:', error));
  };

  const handleEditar = (transaccion) => {
    setTransaccionEditando(transaccion);
    setDatosEdicion({
      id_paseador: transaccion.id_paseador.id_paseador,
      id_propietario: transaccion.id_propietario.id_propietario,
      id_tipo_transaccion: transaccion.id_tipo_transaccion.id_tipo_transaccion,
      id_estado_transaccion: transaccion.id_estado_transaccion.id_estado_transaccion,
      monto: transaccion.monto,
      estado: transaccion.estado,
    });
  };

  const cancelarEdicion = () => {
    setTransaccionEditando(null);
    setDatosEdicion({
      id_paseador: '',
      id_propietario: '',
      id_tipo_transaccion: '',
      id_estado_transaccion: '',
      monto: '',
      estado: '',
    });
  };

  const handleInputChangeEditarTransaccion = (e) => {
    const { name, value } = e.target;

    setDatosEdicion((prevDatosEdicion) => ({
      ...prevDatosEdicion,
      [name]: value,
    }));
  };

  const editarTransaccion = () => {
    if (transaccionEditando) {
      api.editarTransaccion(transaccionEditando.id_transaccion, {
        id_paseador: datosEdicion.id_paseador,
        id_propietario: datosEdicion.id_propietario,
        id_tipo_transaccion: datosEdicion.id_tipo_transaccion,
        id_estado_transaccion: datosEdicion.id_estado_transaccion,
        monto: datosEdicion.monto,
        estado: datosEdicion.estado,
      })
        .then(() => {
          fetchTransacciones();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar transacción:', error));
    }
  };

  const filtrarPorID = (transacciones, filtro) => {
    return transacciones.filter((transaccion) =>
      transaccion.id_transaccion.toString().includes(filtro)
    );
  };

  const toggleEstadoTransaccion = (id, nuevoEstado) => {
    api.editarTransaccion(id, { estado: nuevoEstado })
      .then(() => {
        fetchTransacciones();
      })
      .catch((error) => console.error('Error al cambiar el estado de la transacción:', error));
  };

  const desactivarTransaccion = (id) => {
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
            <a className="navbar-brand">Transacciones</a>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por ID"
                aria-label="Buscar"
                value={filtroID}
                onChange={(e) => setFiltroID(e.target.value)}
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
              <th>ID Paseador</th>
              <th>ID Propietario</th>
              <th>ID Tipo Transacción</th>
              <th>ID Estado Transacción</th>
              <th>Monto</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {transaccionesFiltradas.map((transaccion) => (
              <tr key={transaccion.id_transaccion}>
                <td>{transaccion.id_transaccion}</td>
                <td>
                  {transaccionEditando === transaccion ? (
                    <input
                      type="text"
                      className="form-control"
                      name="id_paseador"
                      value={datosEdicion.id_paseador}
                      onChange={handleInputChangeEditarTransaccion}
                    />
                  ) : (
                    transaccion.id_paseador.id_paseador
                  )}
                </td>
                <td>
                  {transaccionEditando === transaccion ? (
                    <input
                      type="text"
                      className="form-control"
                      name="id_propietario"
                      value={datosEdicion.id_propietario}
                      onChange={handleInputChangeEditarTransaccion}
                    />
                  ) : (
                    transaccion.id_propietario.id_propietario
                  )}
                </td>
                <td>
                  {transaccionEditando === transaccion ? (
                    <input
                      type="text"
                      className="form-control"
                      name="id_tipo_transaccion"
                      value={datosEdicion.id_tipo_transaccion}
                      onChange={handleInputChangeEditarTransaccion}
                    />
                  ) : (
                    transaccion.id_tipo_transaccion.id_tipo_transaccion
                  )}
                </td>
                <td>
                  {transaccionEditando === transaccion ? (
                    <input
                      type="text"
                      className="form-control"
                      name="id_estado_transaccion"
                      value={datosEdicion.id_estado_transaccion}
                      onChange={handleInputChangeEditarTransaccion}
                    />
                  ) : (
                    transaccion.id_estado_transaccion.id_estado_transaccion
                  )}
                </td>
                <td>
                  {transaccionEditando === transaccion ? (
                    <input
                      type="text"
                      className="form-control"
                      name="monto"
                      value={datosEdicion.monto}
                      onChange={handleInputChangeEditarTransaccion}
                    />
                  ) : (
                    transaccion.monto
                  )}
                </td>
                <td>
                  {transaccionEditando === transaccion ? (
                    <input
                      type="text"
                      className="form-control"
                      name="estado"
                      value={datosEdicion.estado}
                      onChange={handleInputChangeEditarTransaccion}
                    />
                  ) : (
                    transaccion.estado
                  )}
                </td>
                <td>
                  {transaccionEditando === transaccion ? (
                    <>
                      <button onClick={editarTransaccion} className="btn btn-success btn-sm">
                        Guardar
                      </button>
                      <button onClick={cancelarEdicion} className="btn btn-secondary btn-sm">
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => handleEditar(transaccion)} className="btn btn-warning btn-sm">
                        Editar
                      </button>
                      <button onClick={() => eliminarTransaccion(transaccion.id_transaccion)} className="btn btn-danger btn-sm">
                        Eliminar
                      </button>
                      <button
                        onClick={() => toggleEstadoTransaccion(transaccion.id_transaccion, transaccion.estado === '1' ? '0' : '1')}
                        className={`btn btn-${transaccion.estado === '1' ? 'danger' : 'success'} btn-sm`}
                      >
                        {transaccion.estado === '1' ? 'Desactivar' : 'Activar'}
                      </button>
                      <button
                        onClick={() => desactivarTransaccion(transaccion.id_transaccion)} 
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

export default Transacciones;
