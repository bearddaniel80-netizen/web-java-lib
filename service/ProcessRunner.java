package example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class ProcessRunner {
    private static final Logger log = LoggerFactory.getLogger(ProcessRunner.class);

    /** Returns stdout; on failure returns the joined command (same as the Python version). */
    public String run(List<String> command) {
        try {
            Process p = new ProcessBuilder(command)
                    .redirectError(ProcessBuilder.Redirect.DISCARD)
                    .start();
            String out = new String(p.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            p.waitFor();
            return out;
        } catch (Exception e) {
            log.warn("Command failed: {}", command, e);
            if (e instanceof InterruptedException) Thread.currentThread().interrupt();
            return String.join(" ", command);
        }
    }
}