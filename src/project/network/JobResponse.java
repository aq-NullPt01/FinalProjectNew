package project.network;

/**
 * Represents the response after submitting a job.
 */
public interface JobResponse {

    boolean isAccepted();

    String getJobId();

    String getMessage();
}