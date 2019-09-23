package mobilize.mx.moviecatalog.models

import org.hibernate.annotations.CreationTimestamp

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.GenerationType

@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long userId
    String firstName
    String lastName
    String email
    String password

    @CreationTimestamp
    Date created
}
