from rest_framework import serializers
from .models import (Administrador, Calificacionescomentarios, Categorias, EstadosTransaccion, LocacionPaseador, LocacionPropietario, Mascotas, Paseadores, Paseos, Propietarios, Reservas, TiposMascota, TiposTransaccion, TiposUsuario, Transacciones, Usuarios)

from rest_framework import serializers
from .models import Usuarios, TiposUsuario

class TipoUsuarioSerializer(serializers.ModelSerializer):
    class Meta:
        model = TiposUsuario
        fields = ('id_tipo_usuario', 'nombre_tipo_usuario', 'descripcion', 'estado')

class UsuarioSerializer(serializers.ModelSerializer):
    tipo_usuario = TipoUsuarioSerializer(read_only=True) 
    id_tipo_usuario = serializers.PrimaryKeyRelatedField(queryset=TiposUsuario.objects.all())

    class Meta:
        model = Usuarios
        fields = ('id', 'id_tipo_usuario', 'tipo_usuario', 'nombres', 'apellidos', 'apodo', 'email', 'direccion', 'edad', 'celular', 'dni', 'password', 'estado', 'created_at', 'updated_at', 'created_by', 'updated_by')

class TipoMascotaSerializer(serializers.ModelSerializer):
    class Meta:
        model = TiposMascota
        fields = ('id_tipo_mascota', 'nombre', 'estado')

class MascotaSerializer(serializers.ModelSerializer):
    id_tipo_mascota = serializers.PrimaryKeyRelatedField(queryset=TiposMascota.objects.all())

    class Meta:
        model = Mascotas
        fields = ('id_mascota', 'id_tipo_mascota', 'nombre', 'raza', 'peso', 'edad', 'necesidades', 'estado', 'created_at', 'updated_at', 'created_by', 'updated_by')

class CategoriaPaseadorSerializer(serializers.ModelSerializer):
    class Meta:
        model = Categorias
        fields = ('id_categoria', 'categoria_nombre', 'descripcion', 'estado', 'created_at', 'updated_at', 'created_by', 'updated_by')

class AdministradorSerializer(serializers.ModelSerializer):
    class Meta:
        model = Administrador
        fields = ('id', 'nombres', 'apellidos', 'nombre_usuario', 'email', 'edad', 'numero', 'dni', 'contraseña')

class DueñoSerializer(serializers.ModelSerializer):
    id_usuario = UsuarioSerializer()

    class Meta:
        model = Propietarios
        fields = ('id_propietario', 'id_usuario', 'calificacion', 'comentario', 'preferencias_paseo', 'saldo', 'disponibilidad', 'ubicacion', 'estado', 'created_at', 'updated_at', 'created_by', 'updated_by')

class PaseadorSerializer(serializers.ModelSerializer):
    id_usuario = serializers.PrimaryKeyRelatedField(queryset=Usuarios.objects.all())
    id_categoria = serializers.PrimaryKeyRelatedField(queryset=Categorias.objects.all())

    class Meta:
        model = Paseadores
        fields = ('id_paseador', 'id_usuario', 'id_categoria', 'calificacion', 'descripcion', 'experiencia', 'ubicacion', 'tarifa', 'saldo', 'disponibilidad', 'estado', 'created_at', 'updated_at', 'created_by', 'updated_by')

class ReservaSerializer(serializers.ModelSerializer):
    id_propietario = serializers.PrimaryKeyRelatedField(queryset=Propietarios.objects.all())  
    id_paseador = serializers.PrimaryKeyRelatedField(queryset=Paseadores.objects.all())

    class Meta:
        model = Reservas
        fields = ('id_reserva', 'id_propietario', 'id_paseador', 'monto', 'fecha_reserva', 'duracion_paseo', 'detalles', 'punto_encuentro', 'lugar_paseo', 'estado', 'created_at', 'updated_at', 'created_by', 'updated_by')

class PaseoSerializer(serializers.ModelSerializer):
    id_reserva = serializers.PrimaryKeyRelatedField(queryset=Reservas.objects.all())

    class Meta:
        model = Paseos
        fields = ('id_paseo', 'id_reserva', 'comentario', 'calificacion', 'costo', 'fecha_paseo', 'duracion_real', 'lugar', 'estado', 'created_at', 'updated_at', 'created_by', 'updated_by')

class CalificacionSerializer(serializers.ModelSerializer):
    id_paseo = PaseoSerializer()

    class Meta:
        model = Calificacionescomentarios
        fields = ('id_calificacioncomentario', 'id_paseo', 'comentario', 'calificacion', 'fecha_calificacioncomentario', 'estado', 'created_at', 'updated_at', 'created_by', 'updated_by')

class TipoTransaccionSerializer(serializers.ModelSerializer):
    class Meta:
        model = TiposTransaccion
        fields = ('id_tipo_transaccion', 'nombre_tipo', 'descripcion', 'estado', 'created_at', 'updated_at', 'created_by', 'updated_by')

class EstadoTransaccionSerializer(serializers.ModelSerializer):
    class Meta:
        model = EstadosTransaccion
        fields = ('id_estado_transaccion', 'nombre_estado', 'descripcion', 'estado', 'created_at', 'updated_at', 'created_by', 'updated_by')

class TransaccionesSerializer(serializers.ModelSerializer):
    id_paseador = serializers.PrimaryKeyRelatedField(queryset=Paseadores.objects.all())
    id_propietario = serializers.PrimaryKeyRelatedField(queryset=Propietarios.objects.all())
    id_tipo_transaccion = serializers.PrimaryKeyRelatedField(queryset=TiposTransaccion.objects.all())
    id_estado_transaccion = serializers.PrimaryKeyRelatedField(queryset=EstadosTransaccion.objects.all())

    class Meta:
        model = Transacciones
        fields = ('id_transaccion', 'id_paseador', 'id_propietario', 'id_tipo_transaccion', 'id_estado_transaccion', 'monto', 'estado', 'created_at', 'updated_at', 'created_by', 'updated_by')

class LocacionPaseadorSerializer(serializers.ModelSerializer):
    id_paseador = serializers.PrimaryKeyRelatedField(queryset=Paseadores.objects.all())

    class Meta:
        model = LocacionPaseador
        fields = ('id_locacion_paseador', 'id_paseador', 'latitud', 'longitud', 'estado', 'created_at', 'updated_at', 'created_by', 'updated_by')

class LocacionPropietarioSerializer(serializers.ModelSerializer):
    id_propietario = serializers.PrimaryKeyRelatedField(queryset=Propietarios.objects.all())

    class Meta:
        model = LocacionPropietario
        fields = ('id_locacion_propietario', 'id_propietario', 'latitud', 'longitud', 'estado', 'created_at', 'updated_at', 'created_by', 'updated_by')
