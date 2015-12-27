
package org.nuno.webapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
	@GET
	public String getIt() {
        return "Hi there!";
    }
}
