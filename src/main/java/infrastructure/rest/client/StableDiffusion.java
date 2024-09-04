package infrastructure.rest.client;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "stable-diffusion-api")
public interface StableDiffusion {

}
