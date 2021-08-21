public class SizeBasedRotationStrategy implements LogRotationStrategy {
    int sizeThresholdInBytes;
    SizeBasedRotationStrategy(int sizeThresholdInBytes){
        this.sizeThresholdInBytes = sizeThresholdInBytes;
    }
    @Override
    public boolean doRotation(Appender appender) {
        if(appender != null && appender.getCurrentSize() > sizeThresholdInBytes)
            return true;
        return false;
    }
}
