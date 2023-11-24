import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const UserTypeSelection = () => {
  const navigate = useNavigate();
  const [selectedType, setSelectedType] = useState(null);

  const handleTypeSelection = (typeId) => {
    // Almacena el tipo de usuario seleccionado
    localStorage.setItem('selectedType', typeId);

    // Redirige a la página de registro
    navigate('/register');
  };

  return (
    <div>
      <h2>Seleccione el tipo de usuario</h2>
      <button onClick={() => handleTypeSelection(1)}>Propietario</button>
      <button onClick={() => handleTypeSelection(2)}>Paseador</button>
    </div>
  );
};

export default UserTypeSelection;