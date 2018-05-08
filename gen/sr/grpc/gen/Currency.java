// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: currency.proto

package sr.grpc.gen;

/**
 * Protobuf enum {@code currency.Currency}
 */
public enum Currency
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>PLN = 0;</code>
   */
  PLN(0),
  /**
   * <code>EUR = 1;</code>
   */
  EUR(1),
  /**
   * <code>USD = 2;</code>
   */
  USD(2),
  /**
   * <code>GBP = 3;</code>
   */
  GBP(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>PLN = 0;</code>
   */
  public static final int PLN_VALUE = 0;
  /**
   * <code>EUR = 1;</code>
   */
  public static final int EUR_VALUE = 1;
  /**
   * <code>USD = 2;</code>
   */
  public static final int USD_VALUE = 2;
  /**
   * <code>GBP = 3;</code>
   */
  public static final int GBP_VALUE = 3;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @Deprecated
  public static Currency valueOf(int value) {
    return forNumber(value);
  }

  public static Currency forNumber(int value) {
    switch (value) {
      case 0: return PLN;
      case 1: return EUR;
      case 2: return USD;
      case 3: return GBP;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Currency>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Currency> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Currency>() {
          public Currency findValueByNumber(int number) {
            return Currency.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return CurrencyProto.getDescriptor().getEnumTypes().get(0);
  }

  private static final Currency[] VALUES = values();

  public static Currency valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private Currency(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:currency.Currency)
}

