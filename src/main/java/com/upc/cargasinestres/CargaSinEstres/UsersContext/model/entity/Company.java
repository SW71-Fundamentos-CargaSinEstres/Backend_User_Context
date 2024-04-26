package com.upc.cargasinestres.CargaSinEstres.UsersContext.model.entity;

import com.upc.cargasinestres.CargaSinEstres.Business.model.entity.Rating;
import com.upc.cargasinestres.CargaSinEstres.Business.model.entity.Servicio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="companies")
public class Company {
    /**
     * The id of the company.
     * This is a primary key.
     * This id is generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the company.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * The TIC of the company.
     */
    @Column(name = "TIC", nullable = false)
    private String TIC;

    /**
     * The address of the company.
     */
    @Column(name = "direction", nullable = false)
    private String direction;

    /**
     * The email of the company.
     */
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * The contact number of the company.
     */
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    /**
     * The password of the company.
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * The photo of the company.
     */
    @Column(name = "logo", nullable = false)
    private String logo;

    /**
     * The description of the company
     */
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * The rating of the company
     */
    @OneToMany(mappedBy="company")
    private List<Rating> ratings;

    /**
     * Membership of the company
     */
    @Column(name="idMembership")
    private Long membershipId; //cambiar a conexion por id

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "company_servicio", // Nombre de la tabla de unión
            joinColumns = @JoinColumn(name = "company_id"), // Columna que hace referencia a la entidad actual (Company)
            inverseJoinColumns = @JoinColumn(name = "servicio_id") // Columna que hace referencia a la entidad relacionada (Servicio)
    )
    private List<Servicio> servicios;
}
