package model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "conv_tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class Conversacion extends EntidadPersistente {

}
