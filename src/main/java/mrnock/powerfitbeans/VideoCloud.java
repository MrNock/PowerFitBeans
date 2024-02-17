package mrnock.powerfitbeans;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobClientBuilder;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import com.sun.jna.platform.win32.WinUser;
import java.io.File;
import java.util.LinkedList;

/**
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 */
public class VideoCloud {

    LinkedList<String> azureVideos = new LinkedList<>();
    public static String videoFileAbsoluteTempPath = System.getProperty("java.io.tmpdir");

    final private String connectStr = "DefaultEndpointsProtocol=https;AccountName=myvideoserver;AccountKey=N8qIEKx8aBdswJm2ZjByjSF0JsqCCcB5VAELyQi204KiuLxt2YDWpQmzFnEmsrIQLnZbZkIiIUD3+AStFiz1oQ==;EndpointSuffix=core.windows.net";
    final private String containerName = "mrnockvideos";

    public VideoCloud() {

        if (videoFileAbsoluteTempPath.isEmpty()) {
            videoFileAbsoluteTempPath = "c:" + File.separator + "temp";
        }

    }

    public void initializeVideoListFromCloud() {
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr).buildClient();
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

        for (BlobItem blobItem : containerClient.listBlobs()) {
            azureVideos.add(blobItem.getName());
        }

    }

    /**
     * This method is used to check if video file needs to be downloaded to Temp
     * dir
     *
     * @param videoFile video to be downloaded.
     * @return
     */
    public boolean downloadVideoIfNecessary(String videoFile) {
        File f = new File(videoFileAbsoluteTempPath + File.separator + videoFile);
        if (!f.exists()) {
            //Check that the video is in azure
            if (azureVideos.contains(videoFile)) {
                //download the video
                BlobClient blobClient = new BlobClientBuilder().connectionString(connectStr)
                        .blobName(videoFile)
                        .containerName(containerName)
                        .buildClient();
                blobClient.downloadToFile(videoFileAbsoluteTempPath + File.separator + videoFile);

            } else {
                //The video file is not uploaded in azure
                return false;
            }

        }
        return true;
    }

}
