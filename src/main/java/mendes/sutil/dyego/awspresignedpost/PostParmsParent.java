package mendes.sutil.dyego.awspresignedpost;

import mendes.sutil.dyego.awspresignedpost.domain.AmzExpirationDate;
import software.amazon.awssdk.regions.Region;

import java.time.ZonedDateTime;

public class PostParmsParent {
    protected final Region region;
    protected final AmzExpirationDate amzExpirationDate;

    public PostParmsParent(
            Region region,
            ZonedDateTime expirationDate
    ) {
        this.region = region;
        this.amzExpirationDate = new AmzExpirationDate(expirationDate);
    }

    public software.amazon.awssdk.regions.Region getRegion() {
        return this.region;
    }

    public mendes.sutil.dyego.awspresignedpost.domain.AmzExpirationDate getAmzExpirationDate() {
        return this.amzExpirationDate;
    }
}
