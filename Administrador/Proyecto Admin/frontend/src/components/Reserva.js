import React, { useEffect, useState } from 'react';
import api from '../api';
import { Link } from 'react-router-dom';

const Reservas = () => {
  const [reservas, setReservas] = useState([]);
  const [reservaEditando, setReservaEditando] = useState(null);
  const [datosEdicion, setDatosEdicion] = useState({
    id_propietario: '',
    id_paseador: '',
    monto: '',
    fecha_reserva: '',
    duracion_paseo: '',
    detalles: '',
    punto_encuentro: '',
    lugar_paseo: '',
    estado: '',
  });
  const [busquedaId, setBusquedaId] = useState('');
  const [reservasFiltradas, setReservasFiltradas] = useState([]);

  const fetchReservas = async () => {
    try {
      const data = await api.obtenerReservas();
      setReservas(data);
      filtrarReservas(data, busquedaId);
    } catch (error) {
      console.error('Error al obtener reservas:', error);
    }
  };

  useEffect(() => {
    fetchReservas();
  }, [busquedaId]);

  const eliminarReserva = (id) => {
    api.eliminarReserva(id)
      .then(() => {
        fetchReservas();
      })
      .catch((error) => console.error('Error al eliminar reserva:', error));
  };

  const handleEditar = (reserva) => {
    setReservaEditando(reserva);
    setDatosEdicion({
      id_propietario: reserva.id_propietario.id_propietario,
      id_paseador: reserva.id_paseador.id_paseador,
      monto: reserva.monto,
      fecha_reserva: reserva.fecha_reserva,
      duracion_paseo: reserva.duracion_paseo,
      detalles: reserva.detalles,
      punto_encuentro: reserva.punto_encuentro,
      lugar_paseo: reserva.lugar_paseo,
      estado: reserva.estado,
    });
  };

  const cancelarEdicion = () => {
    setReservaEditando(null);
    setDatosEdicion({
      id_propietario: '',
      id_paseador: '',
      monto: '',
      fecha_reserva: '',
      duracion_paseo: '',
      detalles: '',
      punto_encuentro: '',
      lugar_paseo: '',
      estado: '',
    });
  };

  const handleInputChangeEditarReserva = (e) => {
    const { name, value } = e.target;

    setDatosEdicion((prevDatosEdicion) => ({
      ...prevDatosEdicion,
      [name]: value,
    }));
  };

  const editarReserva = () => {
    if (reservaEditando) {
      api.editarReserva(reservaEditando.id_reserva, datosEdicion)
        .then(() => {
          fetchReservas();
          cancelarEdicion();
        })
        .catch((error) => console.error('Error al editar reserva:', error));
    }
  };

  const filtrarReservas = (reservas, busquedaId) => {
    const reservasFiltradas = reservas.filter((reserva) =>
      reserva.id_reserva.toString().includes(busquedaId)
    );
    setReservasFiltradas(reservasFiltradas);
  };

  const toggleEstadoReserva = (idReserva, nuevoEstado) => {
    api.toggleEstadoReserva(idReserva, nuevoEstado)
      .then(() => {
        fetchReservas();
      })
      .catch((error) => console.error('Error al cambiar estado de la reserva:', error));
  };

  const desactivarReserva = (idReserva) => {
    toggleEstadoReserva(idReserva, '0');
  };

  const activarReserva = (idReserva) => {
    toggleEstadoReserva(idReserva, '1');
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
            <a className="navbar-brand">Reservas</a>
            <form className="d-flex" role="search">
              <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por ID"
                aria-label="Buscar"
                value={busquedaId}
                onChange={(e) => setBusquedaId(e.target.value)}
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
              <th>ID Propietario</th>
              <th>ID Paseador</th>
              <th>Monto</th>
              <th>Fecha Reserva</th>
              <th>Duración Paseo</th>
              <th>Detalles</th>
              <th>Punto Encuentro</th>
              <th>Lugar Paseo</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {reservasFiltradas.map((reserva) => (
              <tr key={reserva.id_reserva}>
                <td>{reserva.id_reserva}</td>
                <td>{reserva.id_propietario.id_propietario}</td>
                <td>{reserva.id_paseador}</td>
                <td>
                  {reservaEditando === reserva ? (
                    <input
                      type="text"
                      className="form-control"
                      name="monto"
                      value={datosEdicion.monto}
                      onChange={handleInputChangeEditarReserva}
                    />
                  ) : (
                    reserva.monto
                  )}
                </td>
                <td>
                  {reservaEditando === reserva ? (
                    <input
                      type="text"
                      className="form-control"
                      name="fecha_reserva"
                      value={datosEdicion.fecha_reserva}
                      onChange={handleInputChangeEditarReserva}
                    />
                  ) : (
                    reserva.fecha_reserva
                  )}
                </td>
                <td>
                  {reservaEditando === reserva ? (
                    <input
                      type="text"
                      className="form-control"
                      name="duracion_paseo"
                      value={datosEdicion.duracion_paseo}
                      onChange={handleInputChangeEditarReserva}
                    />
                  ) : (
                    reserva.duracion_paseo
                  )}
                </td>
                <td>
                  {reservaEditando === reserva ? (
                    <input
                      type="text"
                      className="form-control"
                      name="detalles"
                      value={datosEdicion.detalles}
                      onChange={handleInputChangeEditarReserva}
                    />
                  ) : (
                    reserva.detalles
                  )}
                </td>
                <td>
                  {reservaEditando === reserva ? (
                    <input
                      type="text"
                      className="form-control"
                      name="punto_encuentro"
                      value={datosEdicion.punto_encuentro}
                      onChange={handleInputChangeEditarReserva}
                    />
                  ) : (
                    reserva.punto_encuentro
                  )}
                </td>
                <td>
                  {reservaEditando === reserva ? (
                    <input
                      type="text"
                      className="form-control"
                      name="lugar_paseo"
                      value={datosEdicion.lugar_paseo}
                      onChange={handleInputChangeEditarReserva}
                    />
                  ) : (
                    reserva.lugar_paseo
                  )}
                </td>
                <td>
                  {reservaEditando === reserva ? (
                    <input
                      type="text"
                      className="form-control"
                      name="estado"
                      value={datosEdicion.estado}
                      onChange={handleInputChangeEditarReserva}
                    />
                  ) : (
                    reserva.estado
                  )}
                </td>
                <td>
                  {reservaEditando === reserva ? (
                    <>
                      <button onClick={editarReserva} className="btn btn-success btn-sm">
                        Guardar
                      </button>
                      <button onClick={cancelarEdicion} className="btn btn-secondary btn-sm">
                        Cancelar
                      </button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => handleEditar(reserva)} className="btn btn-warning btn-sm">
                        Editar
                      </button>
                      <button onClick={() => eliminarReserva(reserva.id_reserva)} className="btn btn-danger btn-sm">
                        Eliminar
                      </button>
                      {reserva.estado === '1' ? (
                        <button
                          onClick={() => toggleEstadoReserva(reserva.id_reserva, '0')}
                          className="btn btn-danger btn-sm"
                        >
                          Desactivar
                        </button>
                      ) : (
                        <button
                          onClick={() => toggleEstadoReserva(reserva.id_reserva, '1')}
                          className="btn btn-success btn-sm"
                        >
                          Activar
                        </button>
                      )}
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

export default Reservas;
