import spock.lang.Specification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PokeapiWrapperSoapSpec extends Specification {

    @Autowired
    private HttpServletRequest request;
	
	@Autowired
	private QueryPokemonService queryPokemonService;

    def "Test Service abilities"() {
        given: "A precondition"
        // Código para configurar el contexto antes de la acción

        when: "An action is performed"
        def result = myService.someMethod()

        then: "A condition is expected"
        result == "expected value"
    }
}