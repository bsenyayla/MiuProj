package com.eregistrar.miueregistrar.service;

import com.eregistrar.miueregistrar.model.Block;

import java.util.List;

/**
 * The interface Block service.
 */
public interface IBlockService {
    /**
     * Save block.
     *
     * @param block the block
     */
    public void saveBlock(Block block);

    /**
     * Gets all block.
     *
     * @return the all block
     */
    public List<Block> getAllBlock();

    /**
     * Gets block by id.
     *
     * @param blockId the block id
     * @return the block by id
     */
    public Block getBlockById(String blockId);

    /**
     * Delete block by id.
     *
     * @param blockId the block id
     */
    public void deleteBlockById(String blockId);

    /**
     * Update block.
     *
     * @param block the block
     */
    public void updateBlock(Block block);
}
