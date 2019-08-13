package example.injection_bug;

import example.injection_bug.doesnt_work.PersonPresenter;
import example.injection_bug.doesnt_work.PetPresenter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotWorking {

	@Autowired
	private PersonPresenter personPresenter;

	@Autowired
	private PetPresenter petPresenter;

	@Autowired
	private ModelRepo<Person> personRepo;

	@Autowired
	private ModelRepo<Pet> petRepo;

	@Test
	public void given_one_person_when_save_then_person_should_be_present_in_the_repo() {
		// given
		personPresenter.init(new Person(1L, "Manu Ginobili"));

		// when
		personPresenter.onSave();

		// then
		assertThat(personRepo.findById(1L))
				.extracting(p -> p.name).isEqualTo("Manu Ginobili");
	}

	@Test
	public void given_one_pet_when_save_then_pet_should_be_present_in_the_repo() {
		// given
		petPresenter.init(new Pet(1L, "Manu Ginobili's pet"));

		// when
		petPresenter.onSave();

		// then
		assertThat(petRepo.findById(1L))
				.extracting(p -> p.name).isEqualTo("Manu Ginobili's pet");
	}

}
