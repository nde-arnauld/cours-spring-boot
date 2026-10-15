package M2fst.demo.repository;

import lombok.val;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.http.auth.aws.signer.RegionSet;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.net.URI;

@Repository
public class S3Repository {
    public void getFileUrl(String fileId) {
        try (S3Client client = S3Client.builder()
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.builder()
                                .accessKeyId("cqBlF80IVJrc1isWW6oK")
                                .secretAccessKey("KPJlY826Qi0d952w4GWmQIvA0zfvWi62hvIyiZlT")
                                .build()))
                .endpointOverride(URI.create("https://s3.bober.ovh"))
                .region(Region.US_EAST_1)
                .sigv4aSigningRegionSet(RegionSet.GLOBAL)
                .forcePathStyle(true)
                .build()) {
            client.listBuckets().buckets().forEach(bucket -> System.out.println("Bucket: " + bucket.name()));
        }
    }
}

/**
 public PresignedUrlResponse generatePresignedUrl(
 String filename,
 String contentType,
 long fileSize) {

 String key = "uploads/" + UUID.randomUUID() + "/" + filename;

 PutObjectRequest putObjectRequest = PutObjectRequest.builder()
 .bucket(bucketName)
 .key(key)
 .contentType(contentType)
 .contentLength(fileSize)
 .build();

 PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
 .signatureDuration(Duration.ofMinutes(15)) // Short expiration for security
 .putObjectRequest(putObjectRequest)
 .build();

 PresignedPutObjectRequest presignedRequest =
 s3Presigner.presignPutObject(presignRequest);

 return new PresignedUrlResponse(
 presignedRequest.url().toString(),
 key
 );
 }
 */