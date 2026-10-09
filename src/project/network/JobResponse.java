package project.network;

public interface JobResponse {

	 // Returns whether the job was accepted
    boolean isAccepted();

    // Returns the unique job identifier
    String getJobId();

    // Returns a message about the job status
    String getMessage();
}
