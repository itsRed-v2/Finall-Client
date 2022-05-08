package net.itsRed_v2.finall.command;

import org.jetbrains.annotations.NotNull;

public record CommandInfo(@NotNull String name,
                          @NotNull String description,
                          @NotNull String[] syntax) {
}
