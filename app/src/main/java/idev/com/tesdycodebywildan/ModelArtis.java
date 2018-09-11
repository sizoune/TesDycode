package idev.com.tesdycodebywildan;


import android.os.Parcel;
import android.os.Parcelable;

public class ModelArtis implements Parcelable {
    private int id, height;
    private String name, country, image, children, dob, description, spouse;

    public ModelArtis(int id, String name, String country, String image, String children, String dob, String description, String spouse, int height) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.image = image;
        this.children = children;
        this.dob = dob;
        this.description = description;
        this.spouse = spouse;
        this.height = height;
    }

    protected ModelArtis(Parcel in) {
        id = in.readInt();
        height = in.readInt();
        name = in.readString();
        country = in.readString();
        image = in.readString();
        children = in.readString();
        dob = in.readString();
        description = in.readString();
        spouse = in.readString();
    }

    public static final Creator<ModelArtis> CREATOR = new Creator<ModelArtis>() {
        @Override
        public ModelArtis createFromParcel(Parcel in) {
            return new ModelArtis(in);
        }

        @Override
        public ModelArtis[] newArray(int size) {
            return new ModelArtis[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(height);
        parcel.writeString(name);
        parcel.writeString(country);
        parcel.writeString(image);
        parcel.writeString(children);
        parcel.writeString(dob);
        parcel.writeString(description);
        parcel.writeString(spouse);
    }
}
