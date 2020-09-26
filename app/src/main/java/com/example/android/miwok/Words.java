package com.example.android.miwok;


public class Words {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mSoundID;
    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public Words(String defaultTranslation, String miwokTranslation, int soundID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mSoundID=soundID;
    }

    Words(String defaultTranslation, String miwokTranslation, int ImageResourceId, int soundID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = ImageResourceId;
        mSoundID=soundID;
    }

    /**
     * Get Miwok translation for the number
     *
     * @returns String
     */

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * get the default English  translation of number
     *
     * @return String
     *
     */
    public int getSoundID(){
        return mSoundID;
    }
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
