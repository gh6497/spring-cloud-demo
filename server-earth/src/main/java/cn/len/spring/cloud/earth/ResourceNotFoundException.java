package cn.len.spring.cloud.earth;

/**
 * @author len
 * 2019-07-03
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
        if(message == null) {
            throw new RuntimeException();
        }

    }
}
