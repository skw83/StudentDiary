package pl.school.doTestow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KlasaTestowa {
	
	private String name;
	
	private String surname;
	
	private Long pesel;
	
	@Override
	public String toString() {
		return "Obiekt [Student] pobrany z formularza: name: " + name + " surname: " + surname + " PESEL: " + pesel;
	}

}
