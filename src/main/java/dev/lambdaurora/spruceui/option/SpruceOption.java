/*
 * Copyright © 2020 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package dev.lambdaurora.spruceui.option;

import dev.lambdaurora.spruceui.Position;
import dev.lambdaurora.spruceui.util.Nameable;
import dev.lambdaurora.spruceui.widget.SpruceWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

/**
 * Represents an option.
 *
 * @author LambdAurora
 * @version 3.3.0
 * @since 1.0.3
 */
public abstract class SpruceOption implements Nameable {
	public final String key;
	private Optional<Text> tooltip = Optional.empty();

	public SpruceOption(String key) {
		Objects.requireNonNull(key, "Cannot create an option without a key.");
		this.key = key;
	}

	@Override
	public String getName() {
		return I18n.translate(this.key);
	}

	public Optional<Text> getOptionTooltip() {
		return this.tooltip;
	}

	public void setTooltip(@Nullable Text tooltip) {
		this.tooltip = Optional.ofNullable(tooltip);
	}

	/**
	 * Returns the display prefix text.
	 *
	 * @return the display prefix
	 */
	public Text getPrefix() {
		return new TranslatableText(this.key);
	}

	/**
	 * Returns the display text.
	 *
	 * @param value the value
	 * @return the display text
	 */
	public Text getDisplayText(Text value) {
		return new TranslatableText("spruceui.options.generic", this.getPrefix(), value);
	}

	public abstract SpruceWidget createWidget(Position position, int width);
}
