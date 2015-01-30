import org.springframework.web.bind.annotation.*;
import org.versly.rest.wsdoc.DocumentationScope;
import org.versly.rest.wsdoc.DocumentationRestApi;


public class MultiApiLevelDocs {

    /**
     * This is the header documentation text for RestApi1.
     */
    @DocumentationRestApi(id = "RestApi1", title = "The RestApi1 API", version = "v1")
    @DocumentationScope("public")
    @RequestMapping("/restapi1/api/v1")
    public class RestApi1 {

        /**
         * Returns the contents of the widgets collecion.
         *
         * @param id The widget identifier.
         */
        @RequestMapping(value = "/widgets", method = RequestMethod.GET)
        public void getWidgets() {
        }
    }


    /**
     * This is the header documentation text for RestApi2.  This API actually spans
     * multiple controller classes, RestApi2_A and RestApi2_B.  This former declares
     * the title, version, and provides API level documentation, the latter just 
     * indicates it has the same identifier as the former and it's resources will
     * be merged in.
     */
    @DocumentationRestApi(id = "RestApi2", title = "The RestApi2 API", version = "v1")
    @DocumentationScope("public")
    @RequestMapping("/restapi2/api/v1")
    public class RestApi2_A {

        /**
         * Returns the contents of the gadgets collecion.
         *
         * @param id The gadget identifier.
         */
        @RequestMapping(value = "/gadgets", method = RequestMethod.GET)
        public void getGadgets() {
        }
    }


    @DocumentationRestApi(id = "RestApi2")
    @DocumentationScope("public")
    @RequestMapping("/restapi2/api/v1")
    public class RestApi2_B {

        /**
         * Some description of the whirlygigs.
         *
         * @param id The whirlygig identifier.
         */
        @RequestMapping(value = "/whirlygigs", method = RequestMethod.GET)
        public void getWhirlygigs() {
        }
    }
}