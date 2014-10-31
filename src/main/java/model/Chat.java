package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("chat")
public class Chat extends Conversacion {

}
