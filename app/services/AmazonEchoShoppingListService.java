package services;

import models.AmazonEchoShoppingList;

import java.util.List;

public interface AmazonEchoShoppingListService {
    /**
     * Returns a list of ShoppingLists
     * @return a list of ShoppingLists
     */
    List<AmazonEchoShoppingList> getShoppingLists();

    /**
     * Get a specific ShoppingList
     * @param id of ShoppingList to get
     * @return ShoppingList with id
     */
    AmazonEchoShoppingList getShoppingList(long id);

    /**
     * Get a specific ShoppingList
     * @param id of ShoppingList to get
     * @return ShoppingList with id
     */
    AmazonEchoShoppingList getShoppingList(String id);

    /**
     * Delete all ShoppingLists
     */
    void deleteAll();

    /**
     * Update ShoppingList
     * @param ShoppingList to update
     */
    void updateShoppingList(AmazonEchoShoppingList ShoppingList);

    /**
     * Delete a specific ShoppingList
     * @param ShoppingList to delete
     */
    void deleteShoppingList(AmazonEchoShoppingList ShoppingList);

    /**
     * Delete a specific ShoppingList
     * @param id of ShoppingList to delete
     */
    void deleteShoppingList(String id);

    /**
     * Delete a specific ShoppingList
     * @param id of ShoppingList to delete
     */
    void deleteShoppingList(long id);

    /**
     * Save a ShoppingList
     * @param ShoppingList to save
     * @return ShoppingList saved
     */
    AmazonEchoShoppingList saveShoppingList(AmazonEchoShoppingList ShoppingList);

}
