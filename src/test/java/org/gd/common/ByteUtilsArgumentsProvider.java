package org.gd.common;

import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.nio.ByteOrder;
import java.util.stream.Stream;

/**
 * @since 2019-10-03
 */
public class ByteUtilsArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(ByteUtils.get()),
                Arguments.of(Java9ByteUtilsImpl.forOrder(ByteOrder.LITTLE_ENDIAN)),
                Arguments.of(Java9ByteUtilsImpl.forOrder(ByteOrder.BIG_ENDIAN))
        );
    }
}
