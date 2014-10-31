package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("hangout")
public class Hangout extends Conversacion {

	
}
