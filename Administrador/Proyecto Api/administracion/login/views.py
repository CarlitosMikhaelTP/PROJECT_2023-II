from django.shortcuts import get_object_or_404
from rest_framework import status
from datetime import datetime
from rest_framework.response import Response
from rest_framework.decorators import api_view
from .models import Administrador, Calificacionescomentarios, Categorias, EstadosTransaccion, LocacionPaseador, LocacionPropietario, Mascotas, Paseadores, Paseos, Propietarios, Reservas, TiposMascota, TiposTransaccion, TiposUsuario, Transacciones, Usuarios
from .serializers import TipoUsuarioSerializer, UsuarioSerializer, TipoMascotaSerializer, MascotaSerializer, CategoriaPaseadorSerializer, AdministradorSerializer, DueñoSerializer, PaseadorSerializer, ReservaSerializer, PaseoSerializer, CalificacionSerializer, TipoTransaccionSerializer, EstadoTransaccionSerializer, TransaccionesSerializer, LocacionPaseadorSerializer, LocacionPropietarioSerializer

@api_view(['POST'])
def registrar_administrador(request):
    serializer = AdministradorSerializer(data=request.data)
    if serializer.is_valid():
        serializer.save()
        response_data = {
            'message': 'Administrador registrado exitosamente.'
        }
        return Response(response_data, status=status.HTTP_201_CREATED, headers={'Access-Control-Allow-Origin': '*'})
    return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST, headers={'Access-Control-Allow-Origin': '*'})

@api_view(['POST'])
def login_administrador(request):
    nombre_usuario = request.data.get('nombre_usuario')
    contraseña = request.data.get('contraseña')
    try:
        administrador = Administrador.objects.get(nombre_usuario=nombre_usuario, contraseña=contraseña)
    except Administrador.DoesNotExist:
        return Response({"error": "Credenciales inválidas"}, status=status.HTTP_401_UNAUTHORIZED, headers={'Access-Control-Allow-Origin': '*'})
    serializer = AdministradorSerializer(administrador)
    return Response(serializer.data, headers={'Access-Control-Allow-Origin': '*'})

@api_view(['GET'])
def obtener_usuarios(request):
    usuarios = Usuarios.objects.all()
    serializer = UsuarioSerializer(usuarios, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_usuario(request, pk):
    usuario = get_object_or_404(Usuarios, pk=pk)

    if request.method == 'GET':
        serializer = UsuarioSerializer(usuario)
        return Response(serializer.data)

    elif request.method == 'PUT':
        datos_actuales = UsuarioSerializer(usuario).data

        serializer = UsuarioSerializer(usuario, data=request.data, partial=True)

        nueva_contraseña = request.data.get('password')
        if not nueva_contraseña:
            serializer.fields.pop('password')  

        if serializer.is_valid():
            if 'created_at' not in request.data:
                serializer.validated_data['created_at'] = datos_actuales['created_at']
            serializer.validated_data['updated_at'] = datetime.now()

            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        usuario.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)
    
@api_view(['GET'])
def obtener_tipo_usuarios(request):
    tipos_usuarios = TiposUsuario.objects.all()
    serializer = TipoUsuarioSerializer(tipos_usuarios, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_tipo_usuario(request, pk):
    tipo_usuario = get_object_or_404(TiposUsuario, pk=pk)

    if request.method == 'GET':
        serializer = TipoUsuarioSerializer(tipo_usuario)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = TipoUsuarioSerializer(tipo_usuario, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        tipo_usuario.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

@api_view(['GET'])
def obtener_reservas(request):
    reservas = Reservas.objects.all()
    serializer = ReservaSerializer(reservas, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_reserva(request, pk):
    reserva = get_object_or_404(Reservas, pk=pk)

    if request.method == 'GET':
        serializer = ReservaSerializer(reserva)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = ReservaSerializer(reserva, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        reserva.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

@api_view(['GET'])
def obtener_paseos(request):
    paseos = Paseos.objects.all()
    serializer = PaseoSerializer(paseos, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_paseo(request, pk):
    paseo = get_object_or_404(Paseos, pk=pk)

    if request.method == 'GET':
        serializer = PaseoSerializer(paseo)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = PaseoSerializer(paseo, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        paseo.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

@api_view(['GET'])
def obtener_calificaciones(request):
    calificaciones = Calificacionescomentarios.objects.all()
    serializer = CalificacionSerializer(calificaciones, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_calificacion(request, pk):
    calificacion = get_object_or_404(Calificacionescomentarios, pk=pk)

    if request.method == 'GET':
        serializer = CalificacionSerializer(calificacion)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = CalificacionSerializer(calificacion, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        calificacion.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

@api_view(['GET'])
def obtener_paseadores(request):
    paseadores = Paseadores.objects.all()
    serializer = PaseadorSerializer(paseadores, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_paseador(request, pk):
    paseador = get_object_or_404(Paseadores, pk=pk)

    if request.method == 'GET':
        serializer = PaseadorSerializer(paseador)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = PaseadorSerializer(paseador, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        paseador.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

@api_view(['GET'])
def obtener_dueños(request):
    dueños = Propietarios.objects.all()
    serializer = DueñoSerializer(dueños, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_dueño(request, pk):
    dueño = get_object_or_404(Propietarios, pk=pk)

    if request.method == 'GET':
        serializer = DueñoSerializer(dueño)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = DueñoSerializer(dueño, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        dueño.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

@api_view(['GET'])
def obtener_administradores(request):
    administradores = Administrador.objects.all()
    serializer = AdministradorSerializer(administradores, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_administrador(request, pk):
    administrador = get_object_or_404(Administrador, pk=pk)

    if request.method == 'GET':
        serializer = AdministradorSerializer(administrador)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = AdministradorSerializer(administrador, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        administrador.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

@api_view(['GET'])
def obtener_categorias_paseador(request):
    categorias_paseador = Categorias.objects.all()
    serializer = CategoriaPaseadorSerializer(categorias_paseador, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_categoria_paseador(request, pk):
    categoria_paseador = get_object_or_404(Categorias, pk=pk)

    if request.method == 'GET':
        serializer = CategoriaPaseadorSerializer(categoria_paseador)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = CategoriaPaseadorSerializer(categoria_paseador, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        categoria_paseador.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

@api_view(['GET'])
def obtener_tipos_mascota(request):
    tipos_mascota = TiposMascota.objects.all()
    serializer = TipoMascotaSerializer(tipos_mascota, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_tipo_mascota(request, pk):
    tipo_mascota = get_object_or_404(TiposMascota, pk=pk)

    if request.method == 'GET':
        serializer = TipoMascotaSerializer(tipo_mascota)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = TipoMascotaSerializer(tipo_mascota, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        tipo_mascota.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

@api_view(['GET'])
def obtener_mascotas(request):
    mascotas = Mascotas.objects.all()
    serializer = MascotaSerializer(mascotas, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_mascota(request, pk):
    mascota = get_object_or_404(Mascotas, pk=pk)

    if request.method == 'GET':
        serializer = MascotaSerializer(mascota)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = MascotaSerializer(mascota, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        mascota.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

@api_view(['GET'])
def obtener_estados_transaccion(request):
    estados_transaccion = EstadosTransaccion.objects.all()
    serializer = EstadoTransaccionSerializer(estados_transaccion, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_estado_transaccion(request, pk):
    estado_transaccion = get_object_or_404(EstadosTransaccion, pk=pk)

    if request.method == 'GET':
        serializer = EstadoTransaccionSerializer(estado_transaccion)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = EstadoTransaccionSerializer(estado_transaccion, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        estado_transaccion.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

@api_view(['GET'])
def obtener_tipos_transaccion(request):
    tipos_transaccion = TiposTransaccion.objects.all()
    serializer = TipoTransaccionSerializer(tipos_transaccion, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_tipo_transaccion(request, pk):
    tipo_transaccion = get_object_or_404(TiposTransaccion, pk=pk)

    if request.method == 'GET':
        serializer = TipoTransaccionSerializer(tipo_transaccion)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = TipoTransaccionSerializer(tipo_transaccion, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        tipo_transaccion.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

@api_view(['GET'])
def obtener_transacciones(request):
    transacciones = Transacciones.objects.all()
    serializer = TransaccionesSerializer(transacciones, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_transaccion(request, pk):
    transaccion = get_object_or_404(Transacciones, pk=pk)

    if request.method == 'GET':
        serializer = TransaccionesSerializer(transaccion)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = TransaccionesSerializer(transaccion, data=request.data, partial=True)

        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        else:
            print("Errors in serializer:", serializer.errors)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        transaccion.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)
    
@api_view(['GET'])
def obtener_locacion_paseadores(request):
    locacion_paseador = LocacionPaseador.objects.all()
    serializer = LocacionPaseadorSerializer(locacion_paseador, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_locacion_paseador(request, pk):
    locacion_paseador = get_object_or_404(LocacionPaseador, pk=pk)

    if request.method == 'GET':
        serializer = LocacionPaseadorSerializer(locacion_paseador)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = LocacionPaseadorSerializer(locacion_paseador, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        locacion_paseador.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

@api_view(['GET'])
def obtener_locacion_propietarios(request):
    locacion_propietario = LocacionPropietario.objects.all()
    serializer = LocacionPropietarioSerializer(locacion_propietario, many=True)
    return Response(serializer.data)

@api_view(['GET', 'PUT', 'DELETE'])
def obtener_locacion_propietario(request, pk):
    locacion_propietario = get_object_or_404(LocacionPropietario, pk=pk)

    if request.method == 'GET':
        serializer = LocacionPropietarioSerializer(locacion_propietario)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = LocacionPropietarioSerializer(locacion_propietario, data=request.data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        locacion_propietario.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)