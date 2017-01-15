# Microbes

A Minecraft mod focusing on the effects and ill effects of engineering bacteria.

This project outline will act as a living document.  No features mentioned here are guaranteed, or may even resemble the final release.

---

### Premise

Microbes will focus on breeding colonies of bacteria.  These bacteria can have harmful or beneficial traits, based on the method of breeding.

Microbes can be extracted into vials.  Vials are then used as a potion system, as an offensive weapon, or to influence the environment in various ways.

### Mechanics:

* Bacteria are initially created by dropping moldy bread into a water source block.
* The source block becomes a bacteria colony, and will begin to multiply.
* Bacteria will quickly multiply up to their maximum capacity, and then spread to neighboring source blocks.
* Bacteria have an age, and while they'll devour a lake if given the chance, they won't be able to take out an entire ocean.
* A microscope can be used to examine vials and determine their properties.
* Traits can be applied or their potency upgraded by dropping catalysts (items) into the colony.  This is less effective in large populations.
* A vial can extract a small amount of bacteria, reducing its population.
* Vials can be drank directly to improve your gut bacteria (hopefully), or crafted by themselves to create a throwable variant.
* Throwable variants create a toxic cloud on impact, affecting enemies or the environment with that bacteria's traits.
* Safety gear makes you immune to airborne bacteria.
* Random mutations occur when bacteria overtake a new block.  This isn't the chief breeding mechanic, but introduces uncertainty to bacteria breeding in unsafe environments.
* Water color hints at population density of colony.

### Traits

Traits define the effects of bacteria on players or the environment.  Each trait has an associated catalyst which increases the potency of that trait.  Bacteria can have more than one trait at once.

* Acidic - Eats blocks, eats flesh.  If it's too acidic it may even eat the blocks holding the liquid in.  Try not to get it on your skin.
* Coagulant - Replaces air blocks with specified coagulated blocks.  Useful for quickly filling in areas, or trapping enemies.  Don't drink if you like to breath.
* Combustible - Kapow.  Potency determines stability and blast radius.  Do be careful.
* Fullness - Applies a long-lasting potion effect that reduces hunger drain.  Potency determines strength of effect.

### Properties

These global properties describe how the colony itself acts.

* Population - Determines how quickly microbes will grow.  It doubles approximately every 30 seconds, modified by growth rate.
* Growth Rate - How often the microbes multiply.  As if these things weren't dangerous enough.
* Age - The number of tiles this bacteria has spread to.  It can also be thought of as "generations", but on a larger scale.
* Resistance - How resistance to random mutation the microbes are, as well their influence by catalysts.  Useful in farming larger colonies.

### Catalysts

Catalysts influence the traits or properties of a colony.  They're more effective on smaller populations and those with reduced resistance. 

###### Traits

* Fermented Spider Eye - Increases *Acidic* trait
* Charcoal - Decreases *Acidic* trait
* Slime Ball - Increases *Coagulant* trait
* Sugar - Decreases *Coagulant* trait
* Gunpowder - Increases *Combustible* trait
* Apple - Increases *Fullness* trait

###### Properties

* Bone Meal - Increases *Growth Rate*.
* Soul Sand - Decreases *Growth Rate*.

Additional catalysts can be defined in the config file.
