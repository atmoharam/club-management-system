/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package dev.kafka.service.model.dev.kafka.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class UserSubscribeSportRequest extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3166501601603689111L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UserSubscribeSportRequest\",\"namespace\":\"dev.kafka.service.model.dev.kafka.avro\",\"fields\":[{\"name\":\"userId\",\"type\":\"string\"},{\"name\":\"sportId\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<UserSubscribeSportRequest> ENCODER =
      new BinaryMessageEncoder<UserSubscribeSportRequest>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<UserSubscribeSportRequest> DECODER =
      new BinaryMessageDecoder<UserSubscribeSportRequest>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<UserSubscribeSportRequest> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<UserSubscribeSportRequest> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<UserSubscribeSportRequest> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<UserSubscribeSportRequest>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this UserSubscribeSportRequest to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a UserSubscribeSportRequest from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a UserSubscribeSportRequest instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static UserSubscribeSportRequest fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence userId;
  private java.lang.CharSequence sportId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public UserSubscribeSportRequest() {}

  /**
   * All-args constructor.
   * @param userId The new value for userId
   * @param sportId The new value for sportId
   */
  public UserSubscribeSportRequest(java.lang.CharSequence userId, java.lang.CharSequence sportId) {
    this.userId = userId;
    this.sportId = sportId;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return userId;
    case 1: return sportId;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: userId = (java.lang.CharSequence)value$; break;
    case 1: sportId = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'userId' field.
   * @return The value of the 'userId' field.
   */
  public java.lang.CharSequence getUserId() {
    return userId;
  }


  /**
   * Sets the value of the 'userId' field.
   * @param value the value to set.
   */
  public void setUserId(java.lang.CharSequence value) {
    this.userId = value;
  }

  /**
   * Gets the value of the 'sportId' field.
   * @return The value of the 'sportId' field.
   */
  public java.lang.CharSequence getSportId() {
    return sportId;
  }


  /**
   * Sets the value of the 'sportId' field.
   * @param value the value to set.
   */
  public void setSportId(java.lang.CharSequence value) {
    this.sportId = value;
  }

  /**
   * Creates a new UserSubscribeSportRequest RecordBuilder.
   * @return A new UserSubscribeSportRequest RecordBuilder
   */
  public static dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest.Builder newBuilder() {
    return new dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest.Builder();
  }

  /**
   * Creates a new UserSubscribeSportRequest RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new UserSubscribeSportRequest RecordBuilder
   */
  public static dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest.Builder newBuilder(dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest.Builder other) {
    if (other == null) {
      return new dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest.Builder();
    } else {
      return new dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest.Builder(other);
    }
  }

  /**
   * Creates a new UserSubscribeSportRequest RecordBuilder by copying an existing UserSubscribeSportRequest instance.
   * @param other The existing instance to copy.
   * @return A new UserSubscribeSportRequest RecordBuilder
   */
  public static dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest.Builder newBuilder(dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest other) {
    if (other == null) {
      return new dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest.Builder();
    } else {
      return new dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest.Builder(other);
    }
  }

  /**
   * RecordBuilder for UserSubscribeSportRequest instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<UserSubscribeSportRequest>
    implements org.apache.avro.data.RecordBuilder<UserSubscribeSportRequest> {

    private java.lang.CharSequence userId;
    private java.lang.CharSequence sportId;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.userId)) {
        this.userId = data().deepCopy(fields()[0].schema(), other.userId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.sportId)) {
        this.sportId = data().deepCopy(fields()[1].schema(), other.sportId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing UserSubscribeSportRequest instance
     * @param other The existing instance to copy.
     */
    private Builder(dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.userId)) {
        this.userId = data().deepCopy(fields()[0].schema(), other.userId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.sportId)) {
        this.sportId = data().deepCopy(fields()[1].schema(), other.sportId);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'userId' field.
      * @return The value.
      */
    public java.lang.CharSequence getUserId() {
      return userId;
    }


    /**
      * Sets the value of the 'userId' field.
      * @param value The value of 'userId'.
      * @return This builder.
      */
    public dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest.Builder setUserId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.userId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'userId' field has been set.
      * @return True if the 'userId' field has been set, false otherwise.
      */
    public boolean hasUserId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'userId' field.
      * @return This builder.
      */
    public dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest.Builder clearUserId() {
      userId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'sportId' field.
      * @return The value.
      */
    public java.lang.CharSequence getSportId() {
      return sportId;
    }


    /**
      * Sets the value of the 'sportId' field.
      * @param value The value of 'sportId'.
      * @return This builder.
      */
    public dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest.Builder setSportId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.sportId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'sportId' field has been set.
      * @return True if the 'sportId' field has been set, false otherwise.
      */
    public boolean hasSportId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'sportId' field.
      * @return This builder.
      */
    public dev.kafka.service.model.dev.kafka.avro.UserSubscribeSportRequest.Builder clearSportId() {
      sportId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserSubscribeSportRequest build() {
      try {
        UserSubscribeSportRequest record = new UserSubscribeSportRequest();
        record.userId = fieldSetFlags()[0] ? this.userId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.sportId = fieldSetFlags()[1] ? this.sportId : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<UserSubscribeSportRequest>
    WRITER$ = (org.apache.avro.io.DatumWriter<UserSubscribeSportRequest>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<UserSubscribeSportRequest>
    READER$ = (org.apache.avro.io.DatumReader<UserSubscribeSportRequest>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.userId);

    out.writeString(this.sportId);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.userId = in.readString(this.userId instanceof Utf8 ? (Utf8)this.userId : null);

      this.sportId = in.readString(this.sportId instanceof Utf8 ? (Utf8)this.sportId : null);

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.userId = in.readString(this.userId instanceof Utf8 ? (Utf8)this.userId : null);
          break;

        case 1:
          this.sportId = in.readString(this.sportId instanceof Utf8 ? (Utf8)this.sportId : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










