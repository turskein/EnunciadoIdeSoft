package com.example.filterservice.Entities;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="comunas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LocalEntity {
    @Column(name="fecha")
    private Date fecha;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id", unique = true, nullable = false)
    private Long localId;
    @Column(name="local_nombre")
    private String localNombre;
    @Column(name="comuna_nombre")
    private String comunaNombre;
    @Column(name="localidad_nombre")
    private String localidadNombre;
    @Column(name="local_direccion")
    private String localDireccion;
    @Column(name="funcionamiento_hora_apertura")
    private Time funcionamientoHoraApertura;
    @Column(name="funcionamiento_hora_cierre")
    private Time funcionamientoHoraCierre;
    @Column(name="local_telefono")
    private String localTelefono;
    @Column(name="local_lat")
    private String localLat;
    @Column(name="local_lng")
    private String localLng;
    @Column(name="funcionamiento_dia")
    private String funcionamientoDia;
    @Column(name="fk_region")
    private Long fkRegion;
    @Column(name="fk_comuna")
    private Long fkComuna;
    @Column(name="fk_localidad")
    private Long fkLocalidad;
}
