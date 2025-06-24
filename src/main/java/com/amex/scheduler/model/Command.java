package com.amex.scheduler.model;

import java.time.LocalDateTime;

public interface Command {
    boolean shouldExecute(LocalDateTime now);
    String getCommandText();
}
