from django.db import models


class Administrador(models.Model):
    nombres = models.CharField(max_length=100)
    apellidos = models.CharField(max_length=100)
    nombre_usuario = models.CharField(unique=True, max_length=50)
    email = models.CharField(unique=True, max_length=255)
    edad = models.IntegerField()
    numero = models.CharField(max_length=15)
    dni = models.CharField(max_length=15)
    contraseña = models.CharField(max_length=255)

    class Meta:
        managed = False
        db_table = 'administrador'


class Calificacionescomentarios(models.Model):
    id_calificacioncomentario = models.AutoField(primary_key=True)
    id_paseo = models.ForeignKey('Paseos', models.DO_NOTHING, db_column='id_paseo')
    comentario = models.TextField()
    calificacion = models.IntegerField()
    fecha_calificacioncomentario = models.DateTimeField(blank=True, null=True)
    estado = models.IntegerField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    updated_at = models.DateTimeField(blank=True, null=True)
    created_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='created_by', blank=True, null=True)
    updated_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='updated_by', related_name='calificacionescomentarios_updated_by_set', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'calificacionescomentarios'


class Categorias(models.Model):
    id_categoria = models.AutoField(primary_key=True)
    categoria_nombre = models.CharField(max_length=20)
    descripcion = models.TextField()
    estado = models.IntegerField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    updated_at = models.DateTimeField(blank=True, null=True)
    created_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='created_by', blank=True, null=True)
    updated_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='updated_by', related_name='categorias_updated_by_set', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'categorias'


class EstadosTransaccion(models.Model):
    id_estado_transaccion = models.AutoField(primary_key=True)
    nombre_estado = models.CharField(max_length=20)
    descripcion = models.TextField()
    estado = models.PositiveIntegerField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    updated_at = models.DateTimeField(blank=True, null=True)
    created_by = models.IntegerField(blank=True, null=True)
    updated_by = models.IntegerField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'estados_transaccion'


class LocacionPaseador(models.Model):
    id_locacion_paseador = models.AutoField(primary_key=True)
    id_paseador = models.ForeignKey('Paseadores', models.DO_NOTHING, db_column='id_paseador')
    latitud = models.DecimalField(max_digits=38, decimal_places=7, blank=True, null=True)
    longitud = models.DecimalField(max_digits=38, decimal_places=7, blank=True, null=True)
    estado = models.PositiveIntegerField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    updated_at = models.DateTimeField(blank=True, null=True)
    created_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='created_by', blank=True, null=True)
    updated_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='updated_by', related_name='locacionpaseador_updated_by_set', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'locacion_paseador'


class LocacionPropietario(models.Model):
    id_locacion_propietario = models.AutoField(primary_key=True)
    id_propietario = models.ForeignKey('Propietarios', models.DO_NOTHING, db_column='id_propietario')
    latitud = models.DecimalField(max_digits=38, decimal_places=7, blank=True, null=True)
    longitud = models.DecimalField(max_digits=38, decimal_places=7, blank=True, null=True)
    estado = models.IntegerField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    updated_at = models.DateTimeField(blank=True, null=True)
    created_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='created_by', blank=True, null=True)
    updated_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='updated_by', related_name='locacionpropietario_updated_by_set', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'locacion_propietario'


class Mascotas(models.Model):
    id_mascota = models.AutoField(primary_key=True)
    id_tipo_mascota = models.ForeignKey('TiposMascota', models.DO_NOTHING, db_column='id_tipo_mascota')
    id_propietario = models.ForeignKey('Propietarios', models.DO_NOTHING, db_column='id_propietario')
    nombre = models.CharField(max_length=20)
    raza = models.CharField(max_length=20)
    peso = models.CharField(max_length=20)
    edad = models.CharField(max_length=20)
    necesidades = models.TextField()
    estado = models.IntegerField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    updated_at = models.DateTimeField(blank=True, null=True)
    created_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='created_by', blank=True, null=True)
    updated_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='updated_by', related_name='mascotas_updated_by_set', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'mascotas'


class Paseadores(models.Model):
    id_paseador = models.AutoField(primary_key=True)
    id_usuario = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='id_usuario')
    id_categoria = models.ForeignKey(Categorias, models.DO_NOTHING, db_column='id_categoria')
    calificacion = models.IntegerField()
    descripcion = models.TextField()
    experiencia = models.TextField(blank=True, null=True)
    ubicacion = models.CharField(max_length=20)
    tarifa = models.DecimalField(max_digits=8, decimal_places=2)
    saldo = models.DecimalField(max_digits=8, decimal_places=2)
    disponibilidad = models.IntegerField()
    estado = models.PositiveIntegerField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    updated_at = models.DateTimeField(blank=True, null=True)
    created_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='created_by', related_name='paseadores_created_by_set', blank=True, null=True)
    updated_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='updated_by', related_name='paseadores_updated_by_set', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'paseadores'


class Paseos(models.Model):
    id_paseo = models.AutoField(primary_key=True)
    id_reserva = models.ForeignKey('Reservas', models.DO_NOTHING, db_column='id_reserva')
    fecha_paseo = models.DateTimeField(blank=True, null=True)
    duracion_real = models.TimeField(blank=True, null=True)
    lugar = models.CharField(max_length=25, blank=True, null=True)
    comentario = models.TextField(blank=True, null=True)
    calificacion = models.IntegerField()
    costo = models.DecimalField(max_digits=10, decimal_places=2)
    estado = models.IntegerField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    updated_at = models.DateTimeField(blank=True, null=True)
    created_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='created_by', blank=True, null=True)
    updated_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='updated_by', related_name='paseos_updated_by_set', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'paseos'


class Propietarios(models.Model):
    id_propietario = models.AutoField(primary_key=True)
    id_usuario = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='id_usuario')
    calificacion = models.IntegerField(blank=True, null=True)
    comentario = models.TextField(blank=True, null=True)
    preferencias_paseo = models.TextField(blank=True, null=True)
    saldo = models.DecimalField(max_digits=8, decimal_places=2)
    disponibilidad = models.IntegerField()
    ubicacion = models.CharField(max_length=20)
    estado = models.IntegerField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    updated_at = models.DateTimeField(blank=True, null=True)
    created_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='created_by', related_name='propietarios_created_by_set', blank=True, null=True)
    updated_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='updated_by', related_name='propietarios_updated_by_set', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'propietarios'


class Reservas(models.Model):
    id_reserva = models.AutoField(primary_key=True)
    id_propietario = models.ForeignKey(Propietarios, models.DO_NOTHING, db_column='id_propietario')
    id_paseador = models.ForeignKey(Paseadores, models.DO_NOTHING, db_column='id_paseador')
    monto = models.DecimalField(max_digits=10, decimal_places=2)
    fecha_reserva = models.DateTimeField(blank=True, null=True)
    duracion_paseo = models.TimeField(blank=True, null=True)
    detalles = models.TextField(blank=True, null=True)
    punto_encuentro = models.CharField(max_length=25, blank=True, null=True)
    lugar_paseo = models.CharField(max_length=20, blank=True, null=True)
    estado = models.IntegerField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    updated_at = models.DateTimeField(blank=True, null=True)
    created_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='created_by', blank=True, null=True)
    updated_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='updated_by', related_name='reservas_updated_by_set', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'reservas'


class TiposMascota(models.Model):
    id_tipo_mascota = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=20)
    estado = models.IntegerField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    updated_at = models.DateTimeField(blank=True, null=True)
    created_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='created_by', blank=True, null=True)
    updated_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='updated_by', related_name='tiposmascota_updated_by_set', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'tipos_mascota'


class TiposTransaccion(models.Model):
    id_tipo_transaccion = models.AutoField(primary_key=True)
    nombre_tipo = models.CharField(max_length=20)
    descripcion = models.TextField(blank=True, null=True)
    estado = models.PositiveIntegerField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    updated_at = models.DateTimeField(blank=True, null=True)
    created_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='created_by', blank=True, null=True)
    updated_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='updated_by', related_name='tipostransaccion_updated_by_set', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'tipos_transaccion'


class TiposUsuario(models.Model):
    id_tipo_usuario = models.AutoField(primary_key=True)
    nombre_tipo_usuario = models.CharField(max_length=20)
    descripcion = models.TextField()
    estado = models.PositiveIntegerField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    updated_at = models.DateTimeField(blank=True, null=True)
    created_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='created_by', blank=True, null=True)
    updated_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='updated_by', related_name='tiposusuario_updated_by_set', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'tipos_usuario'


class Transacciones(models.Model):
    id_transaccion = models.AutoField(primary_key=True)
    id_paseador = models.ForeignKey(Paseadores, models.DO_NOTHING, db_column='id_paseador')
    id_propietario = models.ForeignKey(Propietarios, models.DO_NOTHING, db_column='id_propietario')
    id_tipo_transaccion = models.ForeignKey(TiposTransaccion, models.DO_NOTHING, db_column='id_tipo_transaccion')
    id_estado_transaccion = models.ForeignKey(EstadosTransaccion, models.DO_NOTHING, db_column='id_estado_transaccion')
    monto = models.DecimalField(max_digits=8, decimal_places=2)
    estado = models.PositiveIntegerField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    updated_at = models.DateTimeField(blank=True, null=True)
    created_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='created_by', blank=True, null=True)
    updated_by = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='updated_by', related_name='transacciones_updated_by_set', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'transacciones'


class Usuarios(models.Model):
    id_tipo_usuario = models.ForeignKey(TiposUsuario, models.DO_NOTHING, db_column='id_tipo_usuario')
    nombres = models.CharField(max_length=20)
    apellidos = models.CharField(max_length=20)
    apodo = models.CharField(max_length=20, blank=True, null=True)
    direccion = models.CharField(max_length=35)
    edad = models.PositiveIntegerField()
    celular = models.CharField(unique=True, max_length=9)
    dni = models.CharField(unique=True, max_length=8)
    email = models.CharField(unique=True, max_length=50)
    password = models.CharField(max_length=255)
    estado = models.PositiveIntegerField(blank=True, null=True)
    created_at = models.DateTimeField(blank=True, null=True)
    updated_at = models.DateTimeField(blank=True, null=True)
    created_by = models.ForeignKey('self', models.DO_NOTHING, db_column='created_by', blank=True, null=True)
    updated_by = models.ForeignKey('self', models.DO_NOTHING, db_column='updated_by', related_name='usuarios_updated_by_set', blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'usuarios'
