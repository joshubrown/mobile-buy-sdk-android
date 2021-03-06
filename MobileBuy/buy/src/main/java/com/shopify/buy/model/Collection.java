/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Shopify Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.shopify.buy.model;

import com.google.gson.annotations.SerializedName;
import com.shopify.buy.model.internal.CollectionImage;

import java.util.Date;

import retrofit.Callback;

/**
 * Represents a collection of {@link Product}.
 * In order to get the list of products in a collection, use {@link com.shopify.buy.dataprovider.BuyClient#getProducts(int, String, SortOrder, Callback) getProducts(page, collectionId, sortOrder, callback}.
 */
public class Collection extends ShopifyObject {

    public enum SortOrder {
        COLLECTION_DEFAULT("collection-default"),
        BEST_SELLING("best-selling"),
        TITLE_ASCENDING("title-ascending"),
        TITLE_DESCENDING("title-descending"),
        PRICE_ASCENDING("price-ascending"),
        PRICE_DESCENDING("price-descending"),
        CREATED_ASCENDING("created-ascending"),
        CREATED_DESCENDING("created-descending");

        private final String order;

        SortOrder(String s) {
            order = s;
        }

        public String toString() {
            return order;
        }
    }

    private String title;

    @SerializedName("body_html")
    private String htmlDescription;

    private String handle;

    private boolean published;

    @SerializedName("collection_id")
    private String collectionId;

    @SerializedName("created_at")
    private Date createdAtDate;

    @SerializedName("updated_at")
    private Date updatedAtDate;

    @SerializedName("published_at")
    private Date publishedAtDate;

    private CollectionImage image;

    /**
     * @return The creation date for this collection.
     */
    private Date getCreatedAtDate() {
        return createdAtDate;
    }

    /**
     * @return The updated date for this collection.
     */
    private Date getUpdatedAtDate() {
        return updatedAtDate;
    }

    /**
     * @return The publish date for this collection.
     */
    private Date getPublishedAtDate() {
        return publishedAtDate;
    }

    /**
     * @return This collection's image URL.
     */
    public String getImageUrl() {
        if (image == null) {
            return null;
        }
        return image.getSrc();
    }

    /**
     * @return The title of this collection.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The html description of this collection.
     */
    public String getHtmlDescription() {
        return htmlDescription;
    }

    /**
     * @return The handle for this collection.
     */
    public String getHandle() {
        return handle;
    }

    /**
     * Use {@link Collection#isPublished() isPublished()}.
     */
    @Deprecated
    public String getPublished() {
        return String.valueOf(published);
    }

    /**
     * @return {@code true} if this collection has been published on the shop, {@code false} otherwise.
     */
    public boolean isPublished() {
        return published;
    }

    /**
     * @return The unique identifier for this collection.
     */
    public String getCollectionId() {
        return collectionId;
    }

}