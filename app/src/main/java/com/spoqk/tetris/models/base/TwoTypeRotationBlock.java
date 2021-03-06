package com.spoqk.tetris.models.base;

import android.graphics.Point;

import com.spoqk.tetris.IRotate;

public abstract class TwoTypeRotationBlock extends Block implements IRotate
{
    protected enum Rotation
    {
        HORIZONTAL,
        VERTICAL
    }

    protected Rotation rotation;

    public TwoTypeRotationBlock(Point position, int color)
    {
        super(position, color);
    }

    @Override
    public void updatePos(Point point)
    {
        position = point;
        switch (rotation)
        {
            case HORIZONTAL:
                updateHorizontalRotation(point);
                break;
            case VERTICAL:
                updateVerticalRotation(point);
                break;
        }
    }

    @Override
    public void rotate()
    {
        switch (rotation)
        {
            case HORIZONTAL:
                this.rotation = Rotation.VERTICAL;
                updateVerticalRotation(this.position);
                break;
            case VERTICAL:
                this.rotation = Rotation.HORIZONTAL;
                updateHorizontalRotation(this.position);
                break;
        }
        checkPositionAfterRotation();
    }

    public void unrotate()
    {
        switch (rotation)
        {
            case HORIZONTAL:
                this.rotation = Rotation.VERTICAL;
                updateVerticalRotation(this.position);
                break;
            case VERTICAL:
                this.rotation = Rotation.HORIZONTAL;
                updateHorizontalRotation(this.position);
                break;
        }
    }

    protected abstract void updateHorizontalRotation(Point point);

    protected abstract void updateVerticalRotation(Point point);
}
