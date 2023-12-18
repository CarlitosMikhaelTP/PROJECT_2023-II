const API_BASE_URL = 'http://localhost:8000/api';

const api = {
  async registrar(datosRegistro) {
    const response = await fetch(`${API_BASE_URL}/registrar/`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(datosRegistro),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async login(credenciales) {
    const response = await fetch(`${API_BASE_URL}/login/`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(credenciales),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async obtenerUsuarios() {
    try {
      const response = await fetch(`${API_BASE_URL}/usuarios/`, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
        credentials: 'include',
      });
      const data = await response.json();
      return data;
    } catch (error) {
      console.error('Error al obtener usuarios:', error);
      throw error;
    }
  },

  async eliminarUsuario(id) {
    try {
      const response = await fetch(`${API_BASE_URL}/usuarios/${id}/`, {
        method: 'DELETE',
        credentials: 'include',
      });
      const data = await response.json();
      return data;
    } catch (error) {
      console.error('Error al eliminar usuario:', error);
      throw error;
    }
  },

  async editarUsuario(id, datosUsuario) {
    try {
      const { contraseña, ...datosSinContraseña } = datosUsuario;

      const body = {
        ...datosSinContraseña,
        contraseña: contraseña && contraseña.trim() !== '' ? contraseña : undefined,
      };

      const response = await fetch(`${API_BASE_URL}/usuarios/${id}/`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(body),
        credentials: 'include',
      });

      const data = await response.json();
      return data;
    } catch (error) {
      console.error('Error al editar usuario:', error);
      throw error;
    }
  },
  
  async obtenerTipoUsuarios() {
    const response = await fetch(`${API_BASE_URL}/tipo_usuarios/`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async eliminarTipoUsuario(id) {
    const response = await fetch(`${API_BASE_URL}/tipo_usuarios/${id}/`, {
      method: 'DELETE',
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },
  
  async editarTipoUsuario(id, nuevosDatosTipoUsuario) {
    const response = await fetch(`${API_BASE_URL}/tipo_usuarios/${id}/`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(nuevosDatosTipoUsuario),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async obtenerReservas() {
    const response = await fetch(`${API_BASE_URL}/reservas/`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async eliminarReserva(id) {
    const response = await fetch(`${API_BASE_URL}/reservas/${id}/`, {
      method: 'DELETE',
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },
  
  async editarReserva(id, nuevosDatosReserva) {
    const response = await fetch(`${API_BASE_URL}/reservas/${id}/`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(nuevosDatosReserva),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async obtenerPaseos() {
    const response = await fetch(`${API_BASE_URL}/paseos/`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async eliminarPaseo(id) {
    const response = await fetch(`${API_BASE_URL}/paseos/${id}/`, {
      method: 'DELETE',
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },
  
  async editarPaseo(id, nuevosDatosPaseo) {
    const response = await fetch(`${API_BASE_URL}/paseos/${id}/`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(nuevosDatosPaseo),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async obtenerLocacionPaseadores() {
    const response = await fetch(`${API_BASE_URL}/locacion_paseadores/`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async eliminarLocacionPaseadores(id) {
    const response = await fetch(`${API_BASE_URL}/locacion_paseadores/${id}/`, {
      method: 'DELETE',
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },
  
  async editarLocacionPaseadores(id, nuevosDatosUbicacion) {
    const response = await fetch(`${API_BASE_URL}/locacion_paseadores/${id}/`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(nuevosDatosUbicacion),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async obtenerLocacionPropietarios() {
    const response = await fetch(`${API_BASE_URL}/locacion_propietarios/`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async eliminarLocacionPropietarios(id) {
    const response = await fetch(`${API_BASE_URL}/locacion_propietarios/${id}/`, {
      method: 'DELETE',
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },
  
  async editarLocacionPropietarios(id, nuevosDatosUbicacionPropietario) {
    const response = await fetch(`${API_BASE_URL}/locacion_propietarios/${id}/`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(nuevosDatosUbicacionPropietario),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async obtenerCalificaciones() {
    const response = await fetch(`${API_BASE_URL}/calificaciones/`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async eliminarCalificacion(id) {
    const response = await fetch(`${API_BASE_URL}/calificaciones/${id}/`, {
      method: 'DELETE',
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async editarCalificacion(id, nuevosDatosCalificacion) {
    const response = await fetch(`${API_BASE_URL}/calificaciones/${id}/`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(nuevosDatosCalificacion),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async obtenerPaseadores() {
    const response = await fetch(`${API_BASE_URL}/paseadores/`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async eliminarPaseador(id) {
    const response = await fetch(`${API_BASE_URL}/paseadores/${id}/`, {
      method: 'DELETE',
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },
  
  async editarPaseador(id, nuevosDatosPaseador) {
    const response = await fetch(`${API_BASE_URL}/paseadores/${id}/`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(nuevosDatosPaseador),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async obtenerDueños() {
    const response = await fetch(`${API_BASE_URL}/dueños/`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async eliminarDueño(id) {
    const response = await fetch(`${API_BASE_URL}/dueños/${id}/`, {
      method: 'DELETE',
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },
  
  async editarDueño(id, nuevosDatosPropietario) {
    const response = await fetch(`${API_BASE_URL}/dueños/${id}/`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(nuevosDatosPropietario),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async obtenerAdministradores() {
    const response = await fetch(`${API_BASE_URL}/administradores/`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async eliminarAdministrador(id) {
    const response = await fetch(`${API_BASE_URL}/administradores/${id}/`, {
      method: 'DELETE',
      credentials: 'include',
    });
    return response;
  },

  async editarAdministrador(id, nuevosDatosAdministrador) {
    const response = await fetch(`${API_BASE_URL}/administradores/${id}/`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(nuevosDatosAdministrador),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async obtenerCategoriasPaseador() {
    const response = await fetch(`${API_BASE_URL}/categorias_paseador/`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },
  
  async eliminarCategoriaPaseador(id) {
    const response = await fetch(`${API_BASE_URL}/categorias_paseador/${id}/`, {
      method: 'DELETE',
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async editarCategoriaPaseador(id, nuevosDatosCategoria) {
    const response = await fetch(`${API_BASE_URL}/categorias_paseador/${id}/`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(nuevosDatosCategoria),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async obtenerTiposMascota() {
    const response = await fetch(`${API_BASE_URL}/tipos_mascota/`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async eliminarTipoMascota(id) {
    const response = await fetch(`${API_BASE_URL}/tipos_mascota/${id}/`, {
      method: 'DELETE',
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },
  
  async editarTipoMascota(id, nuevosDatosTipoMascota) {
    const response = await fetch(`${API_BASE_URL}/tipos_mascota/${id}/`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(nuevosDatosTipoMascota),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async obtenerMascotas() {
    const response = await fetch(`${API_BASE_URL}/mascotas/`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async eliminarMascota(id) {
    const response = await fetch(`${API_BASE_URL}/mascotas/${id}/`, {
      method: 'DELETE',
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },
  
  async editarMascota(id, nuevosDatosMascota) {
    const response = await fetch(`${API_BASE_URL}/mascotas/${id}/`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(nuevosDatosMascota),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async obtenerTransacciones() {
    const response = await fetch(`${API_BASE_URL}/transacciones/`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async eliminarTransaccion(id) {
    const response = await fetch(`${API_BASE_URL}/transacciones/${id}/`, {
      method: 'DELETE',
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },
  
  async editarTransaccion(id, nuevosDatosTransaccion) {
    try {
      const response = await fetch(`${API_BASE_URL}/transacciones/${id}/`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(nuevosDatosTransaccion),
        credentials: 'include',
      });
  
      if (!response.ok) {
        const errorData = await response.json();
        console.error('Error al editar transacción:', errorData);
        throw new Error('Error en la solicitud PUT');
      }
  
      const data = await response.json();
      return data;
    } catch (error) {
      console.error('Error al editar transacción:', error);
      throw error;
    }
  },

  async obtenerTiposTransaccion() {
    const response = await fetch(`${API_BASE_URL}/tipos_transaccion/`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async eliminarTipoTransaccion(id) {
    const response = await fetch(`${API_BASE_URL}/tipos_transaccion/${id}/`, {
      method: 'DELETE',
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },
  
  async editarTipoTransaccion(id, nuevosDatosTipoTransaccion) {
    const response = await fetch(`${API_BASE_URL}/tipos_transaccion/${id}/`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(nuevosDatosTipoTransaccion),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async obtenerEstadosTransaccion() {
    const response = await fetch(`${API_BASE_URL}/estados_transaccion/`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },

  async eliminarEstadoTransaccion(id) {
    const response = await fetch(`${API_BASE_URL}/estados_transaccion/${id}/`, {
      method: 'DELETE',
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },
  
  async editarEstadoTransaccion(id, nuevosDatosEstadoTransaccion) {
    const response = await fetch(`${API_BASE_URL}/estados_transaccion/${id}/`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(nuevosDatosEstadoTransaccion),
      credentials: 'include',
    });
    const data = await response.json();
    return data;
  },
};
export default api;
