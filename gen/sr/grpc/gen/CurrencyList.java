// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: currency.proto

package sr.grpc.gen;

/**
 * Protobuf type {@code currency.CurrencyList}
 */
public  final class CurrencyList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:currency.CurrencyList)
    CurrencyListOrBuilder {
  // Use CurrencyList.newBuilder() to construct.
  private CurrencyList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CurrencyList() {
    chosenCurrencies_ = java.util.Collections.emptyList();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private CurrencyList(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {
            int rawValue = input.readEnum();
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              chosenCurrencies_ = new java.util.ArrayList<Integer>();
              mutable_bitField0_ |= 0x00000001;
            }
            chosenCurrencies_.add(rawValue);
            break;
          }
          case 10: {
            int length = input.readRawVarint32();
            int oldLimit = input.pushLimit(length);
            while(input.getBytesUntilLimit() > 0) {
              int rawValue = input.readEnum();
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                chosenCurrencies_ = new java.util.ArrayList<Integer>();
                mutable_bitField0_ |= 0x00000001;
              }
              chosenCurrencies_.add(rawValue);
            }
            input.popLimit(oldLimit);
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        chosenCurrencies_ = java.util.Collections.unmodifiableList(chosenCurrencies_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return CurrencyProto.internal_static_currency_CurrencyList_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return CurrencyProto.internal_static_currency_CurrencyList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            CurrencyList.class, Builder.class);
  }

  public static final int CHOSENCURRENCIES_FIELD_NUMBER = 1;
  private java.util.List<Integer> chosenCurrencies_;
  private static final com.google.protobuf.Internal.ListAdapter.Converter<
      Integer, Currency> chosenCurrencies_converter_ =
          new com.google.protobuf.Internal.ListAdapter.Converter<
              Integer, Currency>() {
            public Currency convert(Integer from) {
              Currency result = Currency.valueOf(from);
              return result == null ? Currency.UNRECOGNIZED : result;
            }
          };
  /**
   * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
   */
  public java.util.List<Currency> getChosenCurrenciesList() {
    return new com.google.protobuf.Internal.ListAdapter<
        Integer, Currency>(chosenCurrencies_, chosenCurrencies_converter_);
  }
  /**
   * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
   */
  public int getChosenCurrenciesCount() {
    return chosenCurrencies_.size();
  }
  /**
   * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
   */
  public Currency getChosenCurrencies(int index) {
    return chosenCurrencies_converter_.convert(chosenCurrencies_.get(index));
  }
  /**
   * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
   */
  public java.util.List<Integer>
  getChosenCurrenciesValueList() {
    return chosenCurrencies_;
  }
  /**
   * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
   */
  public int getChosenCurrenciesValue(int index) {
    return chosenCurrencies_.get(index);
  }
  private int chosenCurrenciesMemoizedSerializedSize;

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (getChosenCurrenciesList().size() > 0) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(chosenCurrenciesMemoizedSerializedSize);
    }
    for (int i = 0; i < chosenCurrencies_.size(); i++) {
      output.writeEnumNoTag(chosenCurrencies_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < chosenCurrencies_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeEnumSizeNoTag(chosenCurrencies_.get(i));
      }
      size += dataSize;
      if (!getChosenCurrenciesList().isEmpty()) {  size += 1;
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32SizeNoTag(dataSize);
      }chosenCurrenciesMemoizedSerializedSize = dataSize;
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof CurrencyList)) {
      return super.equals(obj);
    }
    CurrencyList other = (CurrencyList) obj;

    boolean result = true;
    result = result && chosenCurrencies_.equals(other.chosenCurrencies_);
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getChosenCurrenciesCount() > 0) {
      hash = (37 * hash) + CHOSENCURRENCIES_FIELD_NUMBER;
      hash = (53 * hash) + chosenCurrencies_.hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static CurrencyList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CurrencyList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CurrencyList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CurrencyList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CurrencyList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static CurrencyList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static CurrencyList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static CurrencyList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static CurrencyList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static CurrencyList parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(CurrencyList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code currency.CurrencyList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:currency.CurrencyList)
      CurrencyListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CurrencyProto.internal_static_currency_CurrencyList_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CurrencyProto.internal_static_currency_CurrencyList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              CurrencyList.class, Builder.class);
    }

    // Construct using sr.grpc.gen.CurrencyList.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      chosenCurrencies_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return CurrencyProto.internal_static_currency_CurrencyList_descriptor;
    }

    public CurrencyList getDefaultInstanceForType() {
      return CurrencyList.getDefaultInstance();
    }

    public CurrencyList build() {
      CurrencyList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public CurrencyList buildPartial() {
      CurrencyList result = new CurrencyList(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        chosenCurrencies_ = java.util.Collections.unmodifiableList(chosenCurrencies_);
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.chosenCurrencies_ = chosenCurrencies_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof CurrencyList) {
        return mergeFrom((CurrencyList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(CurrencyList other) {
      if (other == CurrencyList.getDefaultInstance()) return this;
      if (!other.chosenCurrencies_.isEmpty()) {
        if (chosenCurrencies_.isEmpty()) {
          chosenCurrencies_ = other.chosenCurrencies_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureChosenCurrenciesIsMutable();
          chosenCurrencies_.addAll(other.chosenCurrencies_);
        }
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      CurrencyList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (CurrencyList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<Integer> chosenCurrencies_ =
      java.util.Collections.emptyList();
    private void ensureChosenCurrenciesIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        chosenCurrencies_ = new java.util.ArrayList<Integer>(chosenCurrencies_);
        bitField0_ |= 0x00000001;
      }
    }
    /**
     * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
     */
    public java.util.List<Currency> getChosenCurrenciesList() {
      return new com.google.protobuf.Internal.ListAdapter<
          Integer, Currency>(chosenCurrencies_, chosenCurrencies_converter_);
    }
    /**
     * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
     */
    public int getChosenCurrenciesCount() {
      return chosenCurrencies_.size();
    }
    /**
     * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
     */
    public Currency getChosenCurrencies(int index) {
      return chosenCurrencies_converter_.convert(chosenCurrencies_.get(index));
    }
    /**
     * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
     */
    public Builder setChosenCurrencies(
        int index, Currency value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureChosenCurrenciesIsMutable();
      chosenCurrencies_.set(index, value.getNumber());
      onChanged();
      return this;
    }
    /**
     * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
     */
    public Builder addChosenCurrencies(Currency value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureChosenCurrenciesIsMutable();
      chosenCurrencies_.add(value.getNumber());
      onChanged();
      return this;
    }
    /**
     * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
     */
    public Builder addAllChosenCurrencies(
        Iterable<? extends Currency> values) {
      ensureChosenCurrenciesIsMutable();
      for (Currency value : values) {
        chosenCurrencies_.add(value.getNumber());
      }
      onChanged();
      return this;
    }
    /**
     * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
     */
    public Builder clearChosenCurrencies() {
      chosenCurrencies_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
     */
    public java.util.List<Integer>
    getChosenCurrenciesValueList() {
      return java.util.Collections.unmodifiableList(chosenCurrencies_);
    }
    /**
     * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
     */
    public int getChosenCurrenciesValue(int index) {
      return chosenCurrencies_.get(index);
    }
    /**
     * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
     */
    public Builder setChosenCurrenciesValue(
        int index, int value) {
      ensureChosenCurrenciesIsMutable();
      chosenCurrencies_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
     */
    public Builder addChosenCurrenciesValue(int value) {
      ensureChosenCurrenciesIsMutable();
      chosenCurrencies_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated .currency.Currency chosenCurrencies = 1;</code>
     */
    public Builder addAllChosenCurrenciesValue(
        Iterable<Integer> values) {
      ensureChosenCurrenciesIsMutable();
      for (int value : values) {
        chosenCurrencies_.add(value);
      }
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:currency.CurrencyList)
  }

  // @@protoc_insertion_point(class_scope:currency.CurrencyList)
  private static final CurrencyList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new CurrencyList();
  }

  public static CurrencyList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CurrencyList>
      PARSER = new com.google.protobuf.AbstractParser<CurrencyList>() {
    public CurrencyList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new CurrencyList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CurrencyList> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<CurrencyList> getParserForType() {
    return PARSER;
  }

  public CurrencyList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

