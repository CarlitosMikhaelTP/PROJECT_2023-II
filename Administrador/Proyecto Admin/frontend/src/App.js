import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './components/LoginPage';
import RegistroPage from './components/RegistroPage';
import Menu from './components/Menu'; 
import Usuarios from './components/Usuarios'; 
import TipoUsuarios from './components/TipoUsuarios'; 
import Reserva from './components/Reserva'; 
import Paseo from './components/Paseo'; 
import LocacionPropietario from './components/LocacionPropietario'; 
import LocacionPaseador from './components/LocacionPaseador'; 
import Calificacion from './components/Calificacion'; 
import Paseador from './components/Paseador'; 
import Propietario from './components/Propietario'; 
import Administrador from './components/Administrador'; 
import Categoria from './components/Categoria'; 
import TiposMascota from './components/TiposMascota'; 
import Mascota from './components/Mascota'; 
import Transacciones from './components/Transacciones'; 
import TipoTransaccion from './components/TipoTransaccion'; 
import EstadoTransaccion from './components/EstadoTransaccion'; 

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/registrar" element={<RegistroPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/menu" element={<Menu />} />
        <Route path="/menu/usuarios" element={<Usuarios />} />
        <Route path="/menu/tipo_usuarios" element={<TipoUsuarios />} />
        <Route path="/menu/reservas" element={<Reserva />} />
        <Route path="/menu/paseos" element={<Paseo />} />
        <Route path="/menu/locacion_propietarios" element={<LocacionPropietario />} />
        <Route path="/menu/locacion_paseadores" element={<LocacionPaseador />} />
        <Route path="/menu/calificaciones" element={<Calificacion />} />
        <Route path="/menu/paseadores" element={<Paseador />} />
        <Route path="/menu/dueños" element={<Propietario />} />
        <Route path="/menu/administradores" element={<Administrador />} />
        <Route path="/menu/categorias_paseador" element={<Categoria />} />
        <Route path="/menu/tipos_mascota" element={<TiposMascota />} />
        <Route path="/menu/mascotas" element={<Mascota />} />
        <Route path="/menu/transacciones" element={<Transacciones />} />
        <Route path="/menu/tipos_transaccion" element={<TipoTransaccion />} />
        <Route path="/menu/estados_transaccion" element={<EstadoTransaccion />} />
        {/* Otras rutas y componentes aquí */}
      </Routes>
    </Router>
  );
}

export default App;
