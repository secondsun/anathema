# Anathema Version History
Anathema © 2004 - 2012 by The Anathema Developers
Exalted © 2001-2012 by White Wolf Publishing, Inc.

Website: [anathema.github.com](http://anathema.github.com)

## Release 5.1.4

 * Adding in Firearms and Drive

## Release 5.1.3

### Bugfix
* Corrects Essence requirement for [Solar/Investigation] "Oracular Magistrate Understanding".
* Corrects requirements for [Solar/Athletics] "Speed of Light Approach".
* Corrects Charm prerequisites for [Abyssal/Athletics] "Nimble Ghost Grace".

## Release 5.1.2

### Bugfix
* Restores "Exclusive" Charms to all Charm trees.

## Release 5.1.1

### Bugfixes
* Fixes rendering where the upper left node was vertically aligned with later nodes that required movement, e.g. [Solar/Medicine]
* Corrects prerequisites for [Solar/Investigation] "Oracular Magistrate Understanding"

## Release 5.1.0 "Twilight"

Anathema now requires Java 7 Update 21 or later. Windows and OS X releases include a suitable version.
Due to changed dependencies, Anathema only runs on Windows, OS X and Linux.

This version drops the music database. Many features were broken and nobody ever mentioned it,
leading us to the assumption that not many of you used it.

### Features
* New navigation
* New UI for Name Generator
* New UI for Characters
* New UI for Equipment Database
* New "Scribe" perspective, featuring an easy to use editor with a fluent syntax for your notes.
* Windowed mode defaults to a 16:9 resolution
* Abyssal "Withering Phantasmagoria" and its Solar Mirror offer subeffects.
* Adds a new material composition: "Other Wondrous Material", symbolizing everything not covered by the previous entries.
* [Alessio Caiazza] helps us by keeping the order of data in save files stable.
* Customizers can now define the threshold that triggers the high BP cost for Backgrounds.
  As long as the background is lower than or equal to the threshold, Anathema will apply the low cost,
  when it's greater than the threshold, it will apply the high cost.
  The new syntax for Background costs is
    <backgrounds>
      <thresholdCost lowCost="1" highCost="2" threshold="3"/>
    </backgrounds>

### Bugfixes
* Equipment can handle specialty names containing ampersands '&'.
* Sidereals pay extra for their Celestial Manses.
* Serenity Sidereals no longer get two free dots under some circumstances.
* A Lunar's Stamina is factored into her Armour ratings while in War Form
* Durations of the Until...-type are properly shown once more.
* Corrects cost of [Solar/Resistance] "Spirit Strengthens the Skin"
* Corrects the cost of Essence dots for God-Blooded and their ilk both during creation and play.
* Corrects the description of [Solar/Archery] "Essence Arrow Attack".
* Corrects the page for [Lunar/Human] "Blood Shaping Technique".

## Release 5.0.2

### NO FURTHER UPDATES
This is an indicator release to ask you to re-download Anathema from our website.
There are no changes here, but Anathema 5.1, our final major release for Exalted, Second Edition will be available shortly.
Please un-install and re-install Anathema to use it.

We are sorry for the inconvenience.

## Release 5.0.1

There was a critical issue with 5.0.0, rendering the update manager unusable.
This patch fixes it.

Users of 5.0.0, you don't need to worry about your character. Just uninstall 5.0.0 and install this one, and you'll be fine.

## Release 5.0.0 "Amalion"

Anathema now requires Java 7.

On Windows and OS X, we now include a bundled Java Runtime Environment (JRE) to allow Anathema to run.
Because this environment is included with Anathema, there is no need for you to install Java on your computer.
In fact, if you have Java installed only to run a previous version of Anathema, you can now uninstall Java if you wish.

Of course, you can still run Anathema with your system-wide Java installation.
The wiki has more [details](https://github.com/anathema/anathema/wiki/System-Requirements).

This change implies that Mac users now need OS X 10.7.3 or higher.

### Bugfixes.
* [OSX] Gatekeeper no longer views Anathema as "damaged". You still need to allow it to run.
  The wiki has more [details](https://github.com/anathema/anathema/wiki/How-to-get-Anathema-working-on-Mac-with-Gatekeeper-%2810.7.5-and-up%29).

## Release 4.5.5

### NO FURTHER UPDATES
This is the last release of the 4.x release train.
To receive further updates, please un-install and re-install Anathema.

### Bugfixes
* Fixes cost for (Lunar) "Beast Spirit Defense"

## Release 4.5.4

This version drops the option to specify a custom look and feel.
It also makes major changes to the internal screen layout code. If you notice anything that looks odd, please let us know.

### Bugfixes
* Runtime logging works when you update from an earlier version via the auto-updater.
* Experience table is fully visible without collapsing the overview.
* [Alaman13] Adds repurchase to (Solar/Resistance) "Ruin Abasing Shrug"

## Release 4.5.3

### Features
* Fixes the order of toolbar items, menu bar entries, preferences, character templates and sheets
* Allows "Inheritance" Background for Ghost-Blooded and Demon-Blooded
* Lists Infernal Urge as a Spiritual Trait
* Logs runtime info to ``runtime.log`` in the Anathema directory.
     If you encounter any issues with the program or with custom content, go to this file first for diagnosis.

### Bugfixes
* Fixes Drag and Drop in the series editor
* Changes to a character's Virtue Flaw-equivalent enable the Save-button. Also for Ghost Fetters, Ghost Passions.
* Fixes prerequisite for (Generic) "Supreme Perfection of (Ability)"
* Corrects (Martial Arts/Snake Style) "Essence Fangs and Scales Technique"

## Release 4.5.2

### Features
* [Francisco M. Neto] contributes a Portuguese translation.
* Update screen shows the currently running version even if you have a later version installed.
* Update screen shows the progress per file in addition to the overall progress.
* Update system consumes less bandwidth and downloads faster as a result.

### Bugfixes
* Terrestrials can once again learn more than one Celestial Level Martial Arts style.
* Prepares the ground to make the update system more reliable.
* Corrects (Ghost/Honored Ancestor Ways) "Courier In Dreams".


## Release 4.5.1

There was a critical issue with 4.5.0, rendering the release unusable.
This patch fixes it.

## Release 4.5.0 "Zarlath"

We have left sourceforge for good. See the announcement on the homepage for details.
There are some issues with the automated update system. If Anathema appears to be unable to update itself,
please close the dialog, quit the program and download the installer from our website at anathema.github.com.
Please do not leave the updater running for hours on end - you'll just kill our server, and keep everyone else from
downloading Anathema.

### Features
* Charms in the Combo view are sorted alphabetically.
* Charms in the cascade view are sorted somewhat better.
* The update screen shows changes since your current version.
* Anathema has an even more helpful message when a Martial Arts charm does not conform with its expectations.
* (Solar) "Divine Transcendence" and similar Charms apply to re-purchases.
* (Solar) "Divine Transcendence" and similar Charms apply to Charms learned through the Eclipse (etc.) caste power.
* The Charm view colors satisfied charm prerequisites that derive from a general group, such as "Any Excellency".
* The Charm view colors charm prerequisites that are not part of the currently displayed group when they are learned.
     (e.g in the Lunar Shifting Knack cascade, Deadly Beastman Transformation is colored when learned.)
* It is now possible to create custom character templates in a similar manner to custom charms. See documentation on
     the Anathema wiki for details.

### Bugfixes
* (Windows) The uninstaller is more conservative and does not accidentally delete all your programs.
* The Charm Cascades zoom to the pointer, as they used to do.
* Restores the function to CTRL-click a Charm to edit its description.
* Restores the option to save internal playlists in the music database.
* (Solar) "Divine Transcendence" and "Supreme Perfection" and their mirrors no longer count as Excellencies.


## Release 4.4.0 "Yu-Shan"

### Features
* Anathema has a more helpful message when a Martial Arts charm does not conform with its expectations.
* Refurbishes the Charm cascades, saving download size and improving usability

### Bugfixes
* Charm with optional Traits (such as Backgrounds) as prerequisites now work even if the trait is not present.
* Attunement cost is deducted from the Essence Pools when the item is first added.
* Anathema has a more helpful message when the equipment DB can't be converted.
* Adds "Master Horseman's Eye" to the list of effects of "Master Horseman's Techniques"
* The new Charm cascades fix several issues present in the old version

## Release 4.3.0 "Xaal"

We are starting to move away from sourceforge. Starting with this version, your downloads will come directly
from our own server.

### Features
* Anathema now sports an auto-update. Go to "Help => Check for updates"

### Bugfixes
* Corrects cost for (Infernal/Cecelyne) "Bestowal of Accursed Fortune"
* Corrects print pattern for Great Mother's Tears
* Tooltip delay is now capped at 10 seconds

## Release 4.2.4

### Bugfixes
* Items made of 'No magical material' can no longer have artifact stats. (Existing items are unchanged.)
* Custom generic charms with misspelled generic prerequisites don't break the entire tree.
* 'Loading' screen covers the main window consistently.
* Corrects cost for (Infernal/SwliHN) "Force-Suppression Barrier"
* Corrects repurchases for (Solar/Melee) "Golden Destruction Cut" and its Abyssal Mirror.
* The first pick of any multi-learnable Charm (such as Solar/Bureaucracy "Immanent Solar Glory")
    costs experience if learned after character creation

## Release 4.2.3

### Features
* Quick print shows more informed error messages
* Heroic Ghosts can learn Celestial Martial Arts. Common Ghosts remain limited to Terrestrial Styles.
* Words of the Wise for Sidereals, Abyssals and Infernals.

### Bugfixes
* Printing only suggests filenames that actually work
* Quick print works for characters whose names contain slashes
* Quick print works for characters with short names
* The splash screen for Mac users has been enabled

## Release 4.2.2

### Features
* "Words of the Wise" for Solars, Lunars and Dragon-Blooded
* Eye candy

### Bugfixes
* [White Veil] Lunars pay 10/12 XP per CMA charm. The favorization state of Dexterity does not yet factor in
* Recognizes "Artillery" and "Grenade" tagged items as ranged weapons
* Prints readable generic Charm names in the Magic Report
* Improves the way multi-effect Charms are handled. This should make Anathema less prone to crash if you load several characters in a single sitting.

## Release 4.2.1

Existing characters that already know "Dragon-Graced Weapon" need to select at least one elemental effect
to help Anathema calculate the XP/BP cost for the Charm.

### Features
* Two new weapon tags: "Artillery" and "Grenade" from Scroll of Kings
* Weapon tag tooltips show the tag's abbreviation.
* (DB/Melee) "Dragon-Graced Weapon" is elemental.
* Errors on startup show their trace in the GUI, not only the console.
* When Charm data is broken, Anathema provides more helpful exceptions.

### Bugfixes
* Spirits can be created and loaded once more
* Ronin Sidereal have their astrology sheet printed
* Heretical Infernal Charms cost 9XP
* Combos print generic Charms correctly
* Half-Caste and Ghosts print again
* Corrects description for "Armor" weapon tag from Wonders of the Lost Age
* Experience view is usable with expanded overview
* Sidereals can spent all their free points on one College

## Release 4.2.0 "Whitewall"

### Features
* If no PDF reader is installed, Anathema asks you to install one instead of showing an ugly error message.
* Restructured character navigation so there are less tabs-in-tabs.
* The overview is collapsible.
* [Curtis Tasker] Refreshing items in the loadout screen now remembers the checkbox status of all your equipped items.
* Weapon Tag selection page shows explanatory tooltips.

### Bugfixes
* Can refresh items in the loadout screen
* Corrects default descriptions for Sidereal Generic Charms
* Fixes duration for (Sidereal/Stealth) "Blinding the Boar"
* Fixes prerequisites for (Solar/Archery) "Solar Flare Methodology" and its Abyssal Mirror
* Fixes prerequisites for (Solar/Thrown) "Call the Blade" and its Abyssal Mirror
* Fixes cost for (Martial Arts/VBoS) "Metal Storm"

## Release 4.1.1

Anathema no longer supports ``custom.properties``.
Please use the custom data facility introduced in v4.1.0 in its stead, placing your existing file into the repository's ``custom`` folder.

### Features
* [Curtis Tasker] Preferences window has button to reset repository location to default.
* [Curtis Tasker] Preferences window has button to open repository location in OS-Specific File Manager (Explorer, Finder, etc).
* [Curtis Tasker] Preferences window browse button now opens to the location of the current repository.
* [Curtis Tasker] Preferences window repository location field now shows the location of the default repository when it is selected, rather than [Default Repository]
* [Curtis Tasker] Mousewheel Zoom levels on Charm Cascades been smoothed out. (It will zoom less per rotating "click" of your wheel)
* [Curtis Tasker] Zoom-In on Charm Cascades now has a cap, and the existing cap on Zoom-Out has been enlarged.
* [Curtis Tasker] There is now help text for the charm cascades, detailing how to pan, zoom, and reset the view.
* [Curtis Tasker] Movement speed calculation now takes into account mobility penalty.
* [Jesse Belanger] Charm descriptions for Scroll of the Monk, Return of the Scarlet Empress, and Spirits are now incorporated.
* All canonical Yozis are supported as possible patrons for Green Sun Princes. Obviously, they do not have any charms defined beyond the generics, but you are free to hang your favorite custom charm set off of them.

### Bugfixes
* [Curtis Tasker] Dodge DV takes into account mobility penalties from shields.
* [Curtis Tasker] Mousewheel Zoom-Out no longer flips the charm cascade when zooming out too quickly.
* [Curtis Tasker] Charm Cascade now resets zoom levels when changing Charm Types.
* (Infernal Monster Style) Correct Essence prereq for "Screaming Meat Shield" and "One Hand Fury".
* (Infernal/Cecelyne) Correct Charm prereqs for "Swallowed in Eternity"


## Release 4.1.0 "Varang"

From this version onward, Anathema no longer uses the "Equipment.yap" file, but individual files for each item.  It will back up your existing database, convert it, and remove the original Equipment.yap file.

**Anathema now includes a default equipment database**, which contains the mundane and artifact weapons, shields, and armor from the 2E Core and 2.5 Errata.  If Anathema detects no items in your equipment database, it will populate it with the default database.  If you're an existing user and wish to see this database, simply back up your old database, delete the equipment folder from your repository, and re-launch the program.

**We now import custom charms from your repository**, if the data files are provided.
    Consult our [guide](https://github.com/anathema/anathema/wiki/How-to-create-custom-charms-and-spells) to learn more.

Anathema no longer tracks the dots of Lunar Attribute specialties. They never factored into BP and XP, nor were they printed them.

### Features
* Equipment modifiers to DVs now add to pools instead of modifying the static rating, allowing for more flexibility in designing your gear. All imported equipment from earlier releases will have its values doubled to achieve the same impact it had before; adjust as desired. 
* New preference: Allow equipment customization. Allows to overwrite an item's name and description to make it truly yours.
* Equipment items have a "cost" statistic, which is not enforced.
* Equipment cards are now out of beta.
* Character loadout screen shows tooltips for items
* [Shadow493] Added missing Lunar templates from DotFA.
* [Jesse Belanger] Added Charm descriptions for Infernals. Most texts taken from the official Wiki.
* [Curtis Tasker] The character sheet uses your Awareness, Dodge, and Integrity specialties to display Join Battle, Join Debate, Dodge DV, and Mental Dodge DV values.
* [Curtis Tasker] Improved behavior of tabs.
* [Curtis Tasker] Improved look of toolbar buttons.
* [Curtis Tasker] Added a toolbar button for the equipment database.
* [Curtis Tasker] Added a 'Copy Item' button to the equipment database.
* [Curtis Tasker] Added tooltips to the New Item, Copy Item, Save Item, Delete Item buttons in the equipment database.
* [Curtis Tasker] Improved confirmation dialog for item deletion in the equipment database.
* [Curtis Tasker] Improved weapon stats tooltip in the equipment database.  Now shows weapon tags (Overwhelming, Piercing, etc).
* [Curtis Tasker] Default equipment database now included with Anathema.
* Added support for custom charm loading from the repository.
* Abyssal Taint Charms calculate their upgrade cost

### Bugfixes
* Charm Cards now sport the beautiful icons by Democritus.
* Improved rendering of some Charm cascades, notably Solar Melee, Solar Medicine and Solar Hero Style.
* Mobility penalty for equipment is calculated once more
* Half-Caste are printable once more
* Charms that raise the Essence cap still work after reloading
* Character creation calculates the available dots correctly for splats with fixed dots, like Sidereals
* Fixed an issue with attunement for items made of non-magical Materials
* Fixed free Virtue cap for non-Solars at character creation
* [Shadow493] First Age Solars have the correct points
* [Curtis Tasker] Item stats can contain the '&' character
* [Curtis Tasker] Clinch attacks now calculate using the higher of your Strength or Dexterity
* Hero style extension Charms are only available to matching Exalts
* (Solar/Melee) "Honored Companion of the Sun" is present
* (Solar/Melee) "Deft Hands Deflection" has correct cost
* (Solar/Melee) "Rising Sun Slash" and it's Abyssal Mirror have correct keywords and description
* (Solar/Resistance) "Iron Kettle Body" has correct cost
* (Infernal/SWLiHN) "Counter-Conceptual Interposition" requires "Essence-Dissecting Stare"
* (Infernal/Kimbery) "Bitter Heart Unbleeding" has an Essence 3 repurchase
* (Infernal) "Ascendancy Mantle" gives Broken Winged Crane as source
* (Infernal) "Past Life" Background shows plain english name
* (Sidereal/Craft) "World-Shaping Artistic Vision" has no repurchases
* (Abyssal) Updated Mirrored Charms for Exalted 2.5
* (Abyssal) Most backgrounds are limited to loyal Abyssals
* (Abyssal/Resistance) "Wounds Mean Nothing" shows all sources
* (Abyssal/Archery) "Withering Feathered Maelstrom" has correct prerequisites and cost
* (Lunar/Stamina) It is "Purging the Tarnished Silver" now
* (Lunar) "Tattoo Artifact" BG is available to all Lunars except Casteless and Half-Caste


## Release 4.0.0 "Sperimin"

### Changes for Exalted 2.5
* Updated Sidereal XP Cost
* Errata'd Orichalcum to reflect the improved accuracy in melee.
* Revised Charms for Solars, Lunars, Dragon-Blooded, Sidereal, Abyssal and Infernal Exalted
* Added "Shield#" & "Thrust" Tags. Shield# applies its listed mobility penalty.
* It is no longer possible to create old-style shields stats.
* Soak from multiple worn armor no longer stacks, only the highest applies.
* Equipment that modifies various pools no longer stacks, only the highest applies.
* Combos no longer cost XP or BP and drop some editing restrictions
* Weapon Speed cannot fall below 3
* Weapon Rate cannot rise over 5

**Anathema no longer supports First Edition or "classic" Second Edition.**  At first launch, it will create a backup ZIP of your repository, delete all 1E Characters and convert 2E characters to the appropriate template from the Scroll of Errata.

It will also filter your equipment database and remove all stats from 1E and all shield stats. It will delete all items that have no stats remaining after filtering, if they previously had any. **If your Character spent XP to change a Combo and you tracked the expenditure in the XP table, please remove the entry manually to reflect the new rules.**

### Features
* You can enter your own descriptions for Charms and Spells. To do, CTRL-click your Charm and type away.
* New PDFs (via "File Menu => Save as PDF"):
    - Charm Overview. It prints your Charm data with text, just as the books do.
    - Landscape Character sheet. Re-structured to better utilize space.
    - Character Cards. Print a set of charm, spell, and other cards for your character, using the Democritus layout.
* Equipment keeps track of minimum damage
* [Jesse Belanger] Added Charm descriptions for the 2E Core Book, Abyssals and the Ink Monkeys. Most texts taken from the official Wiki.
* New preference: Enable beta content.  Stuff that doesn't seem to break but isn't done yet will hide here. Please give feedback!
* New beta content: An early draft of an extended character sheet.
* New beta content: Equipment cards, when printing Character Cards.

### Bugfixes
* Characters remember which weapons were attuned when saving
* (Infernal/SWLIHN) "Precision Thought-Force Exercise" and "Orbital Impact Storm" attributed to Ink Monkeys
* Duplication of Series possible on Windows systems
* Anathema respects Accuracy and MPDV modifiers from equipment
* Sidereal Colleges names are readable, and the House of Serenity bears the name it has in 2E
* Martial Arts Weapons remember their print state


## Release 3.1.2

If you saved your Lunar from v3.1.0 or before with v3.1.1, your knacks are gone.  To recover them, there's nothing you can do but re-enter your character or directly edit the character save file.

### Features
* Weapon stats can factor in appropriate specialties

### Bugfixes
* Knacks are saved once again (Thanks, Kiren!)
* Characters with Sorcery print even when Anathema runs on Java 7
* "Bio-Luminescence" mutation shows up correctly
* "Flat damage" tag is printed correctly
* Knacks' sources are printed correctly

## Release 3.1.1

We retired our proprietary keyword "NotAlienLearnable" in favor of Exalted's own "Native".  If you have added Charms to Anathema, you need to change them accordingly.  You've been around since First Edition Lunars back in 2006, my friend. Rest in peace.

**From this version onward, 2E Character's with Spells exclusive to 1E won't load.**

Starting from this version, we will begin phasing out support for First Edition and Power Combat and "classic" 2E to focus on Exalted 2.5.  There may be some additional releases for those rulesets, but some time soon, Anathema won't support them.

### Features
* New Preference: Print only those generics the Character knows about.
* Added entry for Anima description
* Charm tooltips show all sources.
* The sourcebook filter orders books alphabetically.
* Charms and Spells can freely define sourcebooks. They are no longer limited to the names we provide.
* Dragon-Blooded breeding motes are calculated into the base pool
* Items with only one printed stat don't have that stat's name printed
* [2E] Lunar Knacks now form a separate category
* [2E] [Shadow493] Added missing Solar templates from DotFA.
* [2E] Added Charm descriptions. Texts taken from the official Wiki:
    - [Scathach] Lunars
    - [Jesse Belanger] Glories of the Most High, Dreams of the First Age

### Bugfixes
* Bonus points view for Mutations no longer appears for experienced characters.
* Combos are editable once more.
* Anathema detects if it can not open a PDF automatically
* Characters aren't marked "dirty" directly after loading
* [2E] Spirits are available as NPCs only. They no longer track BP/XP.
* [2E] Compass: East and Compass: West are shown correctly on the screen.
* [2E] First Age Solars now start out with a level 1 Manse, as is their due.
* [2E] Sidereal Excellencies name Essence as their limit.
* [2E] Solar Hero extensions available only to Solars (and Moonshadows)
* [2E] [Lunar/Beastmen] "Tiger and Seahorse Dynasty" now carries its proper name
* [2E] [Infernal/SWLiHN] "Heuristic Logos Shintai" is learnable


## Release 3.1.0 "Thorns"

We reworked much of the tech behind the scenes.  **If you have custom plugins, they need to be rebuilt.**  If you use the .zip distribution, please delete your "plugins" and "lib" folders before installing.  

### Features
* The toolbar PDF icon now triggers a "quick print" that opens a character sheet without any dialogs
* New preference: Paper format
* Added facilities to show Charm descriptions in the tooltip.
* [2E] Added such descriptions for Dragon-Blooded Charms. Texts taken from the official Wiki.
* [Attila Kelemen] Support for Japanese (etc.) characters on the tabs
* [Dirk Walter] Magic views adapt to window size
* [2E] [Dirk Walter] Added missing Mutations from many sources
* [2E] Added rules for Ghost-Blooded
* [2E] [Dragon-Blooded] "Surging (Ability) Mastery" and "(Ability) Specialty Focus" show up as generic Charms on the sheet

### Bugfixes
* Linux-shell-script works once again.
* Solars don't pay extra for "Mentor" background any longer, might fix a number of background cost issues.
* No more ugly error when trying to add an unnamed background.
* Tooltips for Martial Arts in the Charm Cascades are shown once more
* Less flickery stuff when learning/forgetting a Charm
* [2E] Added (Infernal/SWLIHN) "Force-Suppression Barrier"
* [2E] Added (Infernal/Martial Arts) "Roots of the Brass Lotus". No special rules though.
* [2E] Favored "High level" MA charms now cost 12 XP, as they should
* [2E] Lunar pay XP by the book.
* [2E] [Lunar Knack] "Changing Plumage Mastery" is now printed with its fellow knacks
* [2E] Fixed name of (Ghost) "Essence Lasso Form"
* [2E] Fixed prerequisites of (DB/Bureaucracy] "Benevolent Master's Blessing"
* [2E] [Martial Arts/Throne Shadow Style) Extensions are available to Sidereals alone
* [2E] [Martial Arts/Sapphire Veil of Passion Style] Fixed typo in "Eternal Infatuation Dance"
* [2E] [Infernal/Heretic] "Swallowing the Scorpion" requires Essence 6


## Release 3.0.2

### Bugfixes
Once more, thanks to the unblinking eyes of the people the WW-forum.

* Age-based Essence-caps now work as written
* Multiple Backgrounds of a single type now factor into BP/XP
* [2E] Terrestrials have a their limit break printed
* [2E] Spirits don't try to print Anima and Caste info
* [2E] [Solar/Medicine] "Science of Mutation" adheres to the current errata
* [2E] [Abyssal/Melee] "Savage Shade Style" now requires Melee 2 and can be comboed
* [2E] Offers specials in the pre-defined list of Infernal backgrounds
* [2E] Calculates XP cost for Infernal Spells correctly
* [2E] Allows Infernal Charms to be comboed freely
* [2E] Added (Abyssal/Integrity) "Dark Will Triumphant" from the Thousand Actions
* [2E] Added "Slave-Spawn Summons" and "Fiend-Vassal Conscription" spells
* [2E] Made repurchases for "Essence Engorgement Technique" match its Solar mirror
* [2E] Added re-purchase for "Unquestionable Yozi Authority"
* [2E] Fixed prerequisites for "Sandstrike Blast"


## Release 3.0.1

### Bugfixes
Thanks to the guys from the WW-forum for all of these.
* [2E] Grants material boni for Adamant and Vitriolic materials
* [2E] Elemental Bolt can now be comboed with Loyal Weapon
* [2E] Calculates essence pools for Infernals correctly
* [2E] Eclipses can learn Infernal Charms
* [2E] It's "Eye of the Tempest" now
* [2E] Calculates XP cost for Infernals mostly correct. Spells are still wrong.
* Characters can change off the Eclipse caste during creation
* Does not print craft dots repeatedly.


## Release 3.0.0 "Malfeas"

### Features
* Essence maximum raised to 10.
* Added Age stat, which determines a character's Essence cap.
* [2E] Added an option to upgrade combos for 1 XP, per errata.
* [2E] Character Sheet now lists excellencies in the abilities block
* Added some significant enhancements to equipment handling. It is now possible to specify attunement costs and current attunement state, which is noted on the character sheet. It is also possible for items to affect other character stats, such as Orichalcum Hearthstone Bracers adding to damage, etc..  Many other improvements as well!
* Modified support for Backgrounds, so that they can now have an optional descriptor field. This will hopefully finally clarify the ability to take multiple Artifact picks!
* Added a greyout of trait dots that are above the current maximum.
* Added persistence for Limit.
* Implemented removal of charms when character's statistics are adjusted to be below the prerequisites.
* Numerous, high impact improvements to the charm tree viewer!
* [2E] Added support for Infernals and their charms.
* [2E] Added support for Spirits, Spirit charms, and God-blooded.
* [2E] Added mechanical support for charms like Glory to the Most High and Divine Transcendence.
* [2E] Added mechanical support for Lunar DBT "upgrade" charms, like Devestating Ogre Enhancement
* [2E] Legendary background option added for Dreams characters.
* [2E] Broken Dreams Lunars templates fixed!
* [2E] Rules for Abyssal Appearance as Essence rises are now enforced.
* [2E] Added support for backgrounds dots as a charm prerequisite, and implemented this for Abyssal Whispers and Dragon-Blooded Purity.
* [2E] Adding support for charms which may explicitly be comboed with charms from other abilities (Elemental Bolt Attack being the poster child).
       
* Slightly underneath the hood, all "special" charms such as Ox-Body and so forth are now specified via a data-driven method rather than in the code. This will hopefully facilitate any modding and custom charm efforts greatly!
* A system for specifying charm backward compatibility has been added, allowing for characters to be imported correctly if we make significant modifications to charm data. 
* A vast multitude of miscellaneous bug fixes, both major and minor!


## Release 2.0.2

### Bugs Fixed (Attila Kelemen)
* Anathema runs on Java 7


## Release 2.0.1

### Features
* Fixed assorted printing bugs for 1E and 2E Lunars, and an exception for 1E Lunars.
* [2E] Fixed some errors in the DB Revised templates.
* [2E] Fixed problems with Silver Lunar Resolution and Charms in similar contexts.
* [2E] Restored Ox-Body option selection for Sidereals and Abyssals.
* [2E] Restored the page reference for Wonder-Forging Genius.
* [2E] Addressed minor issues with certain default Background options; among other things, Sidereals should now have Salary by default.
* [2E] Added all Sorcery and Necromancy page references (thanks, Scott!)
* [2E] Lunars can now properly unlearn DBT mutations taken at character creation.


## Release 2.0.0 "Calibration"

### Features
* [2E] Added Abyssal characters to Anathema.
* [2E] Added Lunar characters to Anathema.
* [2E] Added Sidereal characters to Anathema.
* [2E] Consolidated the First Age Solars templates.
* [2E] Added filter code to allow users to adjust what charms are displayed.
* [2E] Added and updated Ink Monkeys charms up through Ink Monkeys 48.
* [2E] Assorted bugs and data-entry errors fixed.


## Release 1.5.1

### Features
* [2E] Bug-fix release to remove Charm errors and Combo-creation bug.
* [2E] Internal changes to shrink the number of Ink_Monkeys plugins.


## Release 1.5.0 "Lookshy"

### Features
* [2E] Updated to add Dawn Solution erratta and Ink Monkeys vols. 30-38.
* [2E] New official charms added to package.
* [2E] New character creation rules (for Solars and DBs) added to package.
* [2E] Dreams of the First Age character templates for Solars and DBs added to package.  Note: the Dreams of the First Age Solar templates give 2 more bonus dots than the the rules do, to allow the player to place the free manse and free cult dots that they automatically get.


## Release 1.4.2

### Features
* [2E] Updated to add Dreams of the First Age erratta and Ink Monkeys vols. 20-22.
* [2E] New official charms added to package.    


## Release 1.4.1 "Great Forks"

### Features
* [2E] Updated to better display new Charms and errata produced since 2008.
* [2E] New official charms added to package.    


## Outcaste Release III (22/03/08)

### Bugs Fixed (Urs)
* Charms are learnable once more (thanks, Axel)


### Outcaste Release II (21/03/08)
- Corrected prerequisites for some charms. 
- Characters knowing these charms might not load. 
- Please contact us if you encounter any problems.

### Features (Thraxis)
* [2E] Lookshy character templates

### Features (Urs)
* Background Dot XP cost is now configurable, as requested by the Binary Phantom

### Bugs Fixed (Urs)
* [2E] Corrected several Charm names (All found by Allan Morstein)
* [2E] Corrected prerequisites for Soul-Enlightening Beneficience (1819750, spotted by the Astral Wanderer)
* [2E] Snake Form no longer Combo-OK
* [2E] Fixed a bug where a separator was missing in the Charm Viewer (found by Jontu Kontar)
* Relaxed restrictions on timing and defense data in Charm-XML (per request of Jontu Kontar)
* Long specialty names no longer push the dots out of the screen (found by Rahod) 


## Outcaste Release I (22/10/07)

### Features (Onii)
* Support for the Black and White Treatises
* Spells are filtered by edition. 

### Features (Urs)
* Support for Threshold Outcaste Dragon-Blooded.

### Bugs Fixed (Urs)
* [2E] Corrected Presence-requirement for Authority-Radiating Stance (thanks to Andy Day and Tybalt Broods)
* [2E] Added translation keys for the various (Element) Charms (thank you,  Scorpio and Gareth)
* [2E] Added Retainers background for Dynasts, Immaculates and Cheraki (thanks again, Scorpio)
* [2E] Corrected Willpower cost for Drowning Embrace (1807106, found by Allan) 
* [2E] Corrected comboability for Falling Star Maneuver (E Allen noticed bug 1809183)


## Release 1.3.1 "Opal Spire Revised" (21/09/07)

### Features
+ [2E] Martial Arts styles from Scroll of the Monk: Imperfect Lotus, with support from Jontu Kontar.
+ Added Pelagial, Claw Speak and High Holy Speech as per ArykAran's request.

### Usability
* The equipment list now appears sorted, thanks to Gareth Jenkins-Jones.
* File selection dialogs now show the supported filetype, thanks to onii.

### Bugs Fixed
* [2E] DB-Excellencies on the sheet appear where they should. (1731018 and several others)
* [1E] Items no longer cause the program to crash. (1755203)
* [2E] Removed Eagle-Wing Style's dependency on Graceful Crane Stance.
* [2E] Fixed an experience-calculation problem with Essence Arrow Technique (1788105, reported by the British SAS) 


## Release 1.3 "Opal Spire" (03/06/07)

### Features
+ [2E] More Dragon-Blooded: Immaculate Monks & Cherak.
+ [2E] Immaculate Martial Arts Styles, kindly provided by Jontu Kontar
+ [2E] On popular demand, the M-Tag now is fully supported. (Thanks to everyone discussing the issue.)
+ [2E] Allowed C-Tag for ranged weapons (Requested by uteck as per Scroll of the Monk.)
+ [2E] Brand-new Charms from Oadenol's Codex

### Usability
+ New Language: Italian. The translation was conceived by Giovanni D'Addabbo of exalteditalia.com and created by Giovanni and Team ITA. Bits and pieces are still missing, but they will soon be done with.
* Revised Charm controls (Thanks to Demo, Jontu and Chris.)
* Improved accuracy of Charm rendering.
* [2E] Generic Charms are ordered in a character-specific way.

### Bugs Fixed
* Printing for 1E characters and 2E mortals is back. (Bug 1705201, found by Hotep.)
* Ox-Body Technique is /once again/ correctly restored for experienced characters (Bug 1704333 by Chris Venus.)
* Martial Arts Charms no longer cost the "upper tier" amount. (Bugs 1689276 and 1704475, observed by Anonymous and confirmed by Etheric1.)


## Release 1.2 "Nexus" (17/04/07)

### ATTENTION
[2E] **Solar Exalts from previous versions knowing generic Martial Arts Charms will be invalid in future releases.** Use this version to convert them by loading them once and saving thereafter.  

### Features
+ [2E] Dragon-Blooded, with all the usual features - including Necromancy rules from the Black Treatise.
+ [2E] Solars with Necromancy. 
+ [2E] Falling Blossom Style from Scroll of the Monk.
+ [1E] "(Type) Exalt Ways" now supports all known valid types.
+ More spells fitted with targets

### Usability
+ Special Charms are finally learned / unlearned on click. (Way easier than changing the cursors.)
* [2E] Martial Arts Generics are shown as type specific, not Martial Arts Charms.
* Charms with multiple variants are correctly unlearned when a parent Charm is unlearned.
* About-Dialog and Repository Browser no longer show 'Cancel'-Buttons.
* 0-Abilities are no longer printed in Character Description printout

### Bugs Fixed
- None? I can hardly believe it.
- Kudos to Sandra, Junto and Flagg for finding some stupid mistakes of mine before they reached bug level.


## Release 1.1.1 "Patch 1" (25/02/07)

* Tagged equipment from version 1.0 no longer breaks the program (Bug 1657429, found by Xanatos and uteck)
* Terrestrial aspect abilities back online (Bug 1667686)
* Martial Arts charm cascades update when MA Ability changes
* [1E/Core] Close combat weapons are editable
* Prevented a possible problem with the "update view" function in equipment
* Load buttons are now sensitive to actions taken in the repository browser (Bug 1657791, found by bartkusa)
* Anathema starts from paths containing umlauts (Bug 1662453)
* Changing a character's XP makes him saveable now (Found by ECR's Fragg) 
* Spirit-Cutting Attack now combos with all abilities (Bug 1657432, found by Xanatos)
* Wonder-Forging Genius is multi-learnable. (Found by Ashtear Hinoarashi)
* "Open after print" now works in Windows Vista
+ Added Terrestrial Hero Style
+ Updated the first three pages of spells from White Treatise



## Release 1.1 "Meru" (11/02/07)

### ATTENTION
**From this version onward, Anathema requires Java 6 or later.**

- Corrected the type of [1E] Lunar Sense-Borrowing Method and Abyssal Corruption-Sensing Scrutiny as well as Dragon-Blooded Strenght of Stone Technique to Simple, which might make combos illegal. Moreover, corrected prerequisites for several [1E] Lunar, Abyssal and Sidereal charms. **Characters knowing these charms might not load.** Please contact us if you encounter any problems.

- This version will no longer load Solars and Heroic Mortals created with with early 0.x versions. Load and re-save them with v1.0 to make them work.

- [1E] Solar Exalts from previous versions knowing variants of Elemental Hazard-Resisting Meditation will be invalid in future releases. Use this version to convert them by loading them once and saving thereafter.  

### Features
+ [1E] All character types now use 2E-Style sheets, allowing them to use equipment and so on.

### Usability
+ "Repository Browser" to delete, copy, im- and export items from the repository
+ Toolbar with transparent icons (Proposed by Democritus)
+ The program now makes an informed guess at the standard printing error, namely the file being in use. (Requested by Peter Blake)
+ Windows Installer finally online
+ [1E] Solar "Elemental Hazard-Resisting Meditation" now uses the sub-effect interface.
* Some twiddling with the series view
* Fixed layout issues in music, hearts blood, linguistics views
* Added intelligent enforcement of 1-dot-minimum for Craft subtraits.
* "Character concept" moved to "Description" screen.
* Cost for sorcery-type Charms now is "Varies" throughout the database.  

### Bugs Fixed
* Series should be loading once again (Thanks to Jontu Kontar)
* Fixed a potential problem with series overwriting one another
* Characters with Craft specialties now can be loaded (Discovered by ArsGlacialis)
* Ox-Body Technique is now correctly restored for experienced characters (Report 1619249, discovered by Ash)
* [1E/Core Rules] Rate no longer shows when dealing with close combat weapons. (Thanks ipsi)
* [1E] Fixed two problems with Abyssal Appearance/Essence relation
* [1E] Weapon speeds can be negative (Found by uteck)
* [1E] Outcaste Dragon-Bloodeds' Breeding is no longer lowerable when experienced.
* [1E] DBs exiled to Lookshy now truly purchase BGs as if they were born there.
* [1E] DBs actually born in Lookshy have minimum Stealth 1, not 2.
* [1E] Martial Artists from the Sequestered Tabernacle are now limited to the styles named in the book.
* Crafts now register as a favored ability (Reported by ArsGlacialis & Peter Blake)
* Experienced specialty values are displayed correctly after loading

### [1E] Charms Corrected (Kudos to Ricardo)

#### Dragon-Blooded
* Correct name for Swallows Defend the Nest
* Correct type for Strenght of Stone Technique
* Correct duration for Breath of Earth Trance, Strength of Stone Technique
* Correct prerequisites for Purifying Blood Ascendancy, Pounding Surf Style, Scent-of-Crime Method, Swallows Defend the Nest
* Correct cost for Unflagging Vengeance Meditation, Breath of Earth Trance, Warlord's Convocation, Auspicious First Meeting Attitude, Naked Thief Style, Instant Disguise Prana, Life-Swelling Sap Strike, Dance of Flashing Swords

#### Lunars 
* Correct name for Weapon-Shaping Prana, Form-Fixing Method
* Correct prerequisites for Unspeaking Aura of Dread, Blossoming Gift of Luna, Ox-Body Technique, Wolf Endurance Method  
* Correct type for Invulnerable Moonsilver Carapace, Sense-Borrowing Method
* Correct cost for Masking the Brilliant Form, Deadly Viper Strike, Mighty Bear Crush, Hyena Jaw Technique, Ossific Shard Shot, Tiger Claw Swat, Eagle Eye Advantage, Form-Fixing Method, Tattoo-Cutting Wisdom, Moonsilver-Shaping Rite, Celestial Circle Sorcery
          
#### Abyssals
* Correct name for Bone Graft Technique, Attunement-Shattering Block
* Correct duration for Shadow Races the Light
* Correct type for Furious Blade, Soul-Searing Blow, Five Shadow Feint, Attunement-Shattering Block, Strength Stealing Technique, Corruption-Sensing Scrutiny
* Correct cost for Pulse of the Prey, Fetter the Beast, Wyld-Slaying Burst, Rampant Pestilence Method, Unsurpassed Plague Kiss, Labyrinth Circle Necromancy
* Correct prerequisites for Ivory Spine Attack, Bone Arsenal Method, Bone Graft Technique, Spider Pounce Technique, Ghost-Warding Glyph, Exquisite Etiquette Style, Sin-Sensing Meditation
          
#### Sidereals
* Correct type for Smiling at the Damned, Marvelous Inclusion of Details, Systematic Understanding of Everything, Hungry Touch
* Correct duration for Prior Warning  
* Correct cost for One Direction Invocation, Neighborhood Relocation Scheme, Conning Chaos Technique, End Debate
* Correct prerequisites for Destiny-Knitting Entanglement, Cash and Murder Games, Of the Shape of the World, Inevitable Pursuit, Slick Essence Replenishment


## Release 1.00 "Lap" (22/10/06)

### ATTENTION
Characters knowing 2e "Phoenix Renewal Tactic" or 1e "(Type) Exalt Ways" are in an illegal state after loading (but should load nonetheless). To fix this, select those effects you learned and re-save your character. This might lead to problems if you try to "un-learn" the charm altogether

1st Edition Solar "Elemental Protection Prana" will be switched over as soon as Solars and Abyssals are migrated to the new printing engine. **Please contact us if you encounter any problems.**

### Features
+ More rules supported, including:
    - Equipment
    - Craft
    - Linguistics
+ Added proper support for Charms with multiple variants.
+ Motivation now is changeable

### Usability
+ New art through and through
+ New "New" and "Load" dialogs
+ Basic Messaging implemented, informs about the goings-on within the program.
* Predefined "Connections"-Background available for Sidereals and Dragon-Blooded (Thanks to Ricardo)

### Miscellaneous
+ New website
+ Some tinkering with linux shell script & Mac OS launcher
+ Supports Mac "Command" key in menu hotkeys

### Bugs Fixed
* Corrected charm prerequisites for "Fivefold Bulwark Stance", "Invincible Fury of the Dawn", "Mist on Water Attack"
* Corrected min. Bureaucracy value for "Underling Invisibility Practice" (Spotted by ever-vigilant Ricardo)
* Corrected charm type for "Heart-Brightening Presentation Style" (Same here)
* Added two spells from Savant & Sorcerer (...)
* Corrected cost entry for "Durability of Oak Meditation" (Bug 1578859: Thanks to ipsi, for a change) 
* Fixed a problem with Dragon-Blooded Style-Countering Meditation (MartialArts)
* Fixed a problem with Heart's Blood (Name had to be null for the button to go green.)
* Corrected enablement/disablement of background-addition button (Must not be empty for button to go green.)

## Release 0.11 "Kirighast" (11/06/06)

### Features
+ Support for Exalted, Second Edition with
    - Both character types from the main rulebook.
    - All Charms from the core book as well as the first two supplements.
    - Intimacies
+ Character Description now sports a "Player" field.
+ Anathema now accepts user-defined strings. The file "custom.properties" (or a locale-specific variant) in the main directory is read at startup.
* There have been major changes to the handling of customized natures. Refer to "nature_instructions.txt" for details.

### Reporting
+ An all new character sheet with advanced features:
+	Combo-field prints only when combos learned
+	Prints caste-specific Anima ability: To use, define key "Sheet.AnimaPower.[CASTE/ASPECT].[EDITION]" 
+	in custom.properties (see above), where [EDITION] can either be "FirstEdition" or "SecondEdition"
+	Makes use of the as yet incomplete Equipment and Crafts models
+	Variable paper format
+ Series and Notes (finally) are printable.

### Usability
+ CharmCascades now honor the preferred ruleset.
* Revamped the spell selection view
* 	View now filters illegals spells from mass-selection without throwing an exception
*	Removed the "All Spells" filter. It was a major speedbump and we felt it to be largely useless.
* Greatly improved speed of Charm trees.
* Negative experience point entries are now added to "Misc. spendings" instead of reducing the XP total.
* Changes to the magic database model allowed for
* 	Charm durations to be translated.
*	Page numbers to be locale-specific
* Charm attribute requirements now use proper spanish grammar.	

### Mac OS X
+ Hired wordman to tend to the Mac's needs.
+ As of this version there will be special archives for Macs.
* Improved look & feel.
* Let us know what you think and where to improve even more.

### Bugs Fixed
* Replaced "Periphrase" by "Periphrasis", as is due in English.
* Fixed an error in the Linux launcher.
* Violet Bier of Sorrows' "Conclusion Pursuing Approach" is now attributed as "Prayer Strip".
* Power Combat's "Glorious Solar Saber" now has a mote cost of 6.
* The DBT-Gift "Enhanced Senses" can be learned twice (Reported as Bug 1490754)
* Fixed translations for some Necromancy-Spells

### Features Missing
- Experienced second edition Characters' motivation is not yet changeable
- The main menu on Mac OS X is still called 'Anathema' instead of the usual 'File'.


## Release 0.10 Patch 1 (26/03/06)

### Miscellaneous
+ Added a Linux launch script (provided by the illustrious Cerebral) to the distribution.
* Fixed calculation for Lunar attribute points.
* Lunars are able to learn Shadowlands circle Necromancy.
* Changed Lunars' charm selection color


### Reporting
+ The character's ruleset is now included on the voidstate sheet.
* Fixed printing, was broken for all character types but Lunars (1453475:Problem with pdf export)
* Backgrounds are sorted alphabetically on the character sheets.
* "Extra Action" and "Martial Arts" are two words on the character sheets.
* Caste / Aspect names are internationalized on the character sheets.
* Dragon-Blooded without any Backgrounds whatsoever have their Anima table filled out anyway.


## Release 0.10 "Juche" (19/03/06)

### ATTENTION
- There are two issues that **might prevent your previously saved character from loading with this version**:
- The prerequisite Charms for the Dragon-Blooded Brawl Charm "Bonds of Unbreakable Ice Technique" now correctly include "Riptide Method". 
- The combo rules have been corrected and now check whether comboed Extra Action and Supplemental Charms use the same Ability.
- **Please contact us if you encounter any problems, we will fix your character file.**

### Features
+ Lunars are finally done, along with the usual features.
+ Backgrounds of experienced characters are now changeable. (They were in 0.9, but that was unintentional)
    - Experience cost for these changes is calculated as per the Player's Guide.
    - Some Backgrounds (Sorcery, Necromancy, Breeding) remain immutable, Savant is not lowerable.
+ Ricardo has translated the entirety of Terrestrial Charms into Spanish.

### Usability
+ Charms are ordered by (topological) tree-order on the character sheet.
+ The character sheet now handles an unlimited number of Charms (Fixing Bug 1289209 and a RFE)
+ Spells are sorted alphabetically in spell-selection screens.
+ The combo-creation screen displays tooltips for charms.
+ Added various operations to the charm visualization screens:
    - Zoom: Mousewheel or Right-Click-and-Drag (Up to zoom out, Down to zoom in)
    - Center on location: Right-Click
    - Reset: Double-click the right mouse button.
* Re-Built the Charm visualization system.
* Improved behaviour of "Requirement"-Nodes in the charm trees.
* Overview now factors in bonus points gained from flaws when coloring the total.

### Miscellaneous
* All Sidereal Abilities now go up to seven.
* Mortal Abilities, on the other hand, are limited to 5 dots once more.
* Experience point totals with 4 digits are now correctly displayed. (1000xp... wow: Bug 1429973)
* Fixed a problem with the priorization of Attributes with Abyssal Exalted.
* Abbreviated "Book of Bone & Ebony" to "Bone & Ebony" due to problems with the title's length.
* Fixed the odd "jumping" in the Sidereal college view.
* Combo rules fixed: Extra Action and Supplemental Charm must be of the same ability.

### Charms Fixed (so many they get a category of their own)
* Artful Maiming Onslaught: Charm Type is  Supplemental. (Bug Report 1421735)
* Essence Fangs and Scales Technique: Duration  is One scene. (Bug 1430224)
* Ebony Spur Technique: Combos with all abilities (Reported by Ricardo R.)
* Mountain Toppling Method: Duration is One turn (Still.)
* Tornado Offense Technique: Charm Type is Extra Action (Again.)
* Bonds of Unbreakable Ice Technique: Prerequisite "Riptide Method" (Shame on me, Praises to Ricardo.)
* In addition, the following Charms had typos fixed: (Guess who found them all.)
    - Falsehood Unearthing Attitude
    - Sweeten-the-Tap Method
    - Persistent Hornet Attack
    - Sliding Glacier Grip
    - Most Beneficent Seed of the Five Dragons


## Release 0.9 "Icehome" (22/10/05)

### ATTENTION
The Celestial "Dream Pearl Courtesan" Martial Arts Style has been moved to the general Martial Arts Cascades. This might render previously saved characters of the Abyssal Moonshadow Caste invalid. **Please contact us if you encounter any problems, we will fix your character file**.

### Note
Please note that the "Pain Tolerance" merit does not yet factor into the character's total pain tolerance rating.

### Features
+ Anathema now boasts an internal random name generator.
+ Experienced Exalts can now raise their Essence up to 7.
+ Experienced Solars and Abyssals are now able to learn Sidereal Martial Arts.
+ The rules for Terrestrial introduction into the Celestial Martial Arts are now supported.
+ Added the beginnings of an interface for Merits and Flaws.
+ Added various templates for Dragon-Blooded characters, to which Ricardo Rodriguez contributed quite a bit.
+ "Dream Pearl Courtesan" Style is now treated as regular Martial Arts.
+ Added an overview panel to the Sidereal Astrology screen.
+ Permanent pain tolerance (as per the Abyssal "Insensible Corpse Technique") now registers on the character sheet. (Dedicated to Ipsi, who did not tire of asking for it.)

### Usability
+ Integrated the Eclipse/Moonshadow-charms into the main charm tab.
+ Added a preference-setting for the inititally selected ruleset (For Ricardo, thank you for all the help!)
+ Moved Solar Virtue Flaw to a separate tab
+ Anathema now checks whether the repository directory set is the default repository and is thus able to adapt to changes of installation path.
+ You can now add single files to the music database
- Disabled free editing of repository path
* Reduced the amount of information in the overview - we felt it got too crowded to be of use:
    - Removed Essence display
    - Removed Willpower display
    - Removed Virtue Flaw display

### Miscellaneous
+ Added an "About" Dialog (as per RFE 1261801)
+ Added Charms from the Aspect Books
+ Added Subtle Comprehension Technique from "Outcaste", thanks to Ricardo.
+ Virtue panel now fills the entire space available.
* Corrected name for "Feeling the Dragon's Bones"
* Ricardo found and fixed some mistakes with Lower-Class Outcaste:
    - The minimum abilities now behave correctly
    - All backgrounds are available
* Fixed a problem with removing and once again adding backgrounds, found by Ricardo


## Release 0.8.1 "Hollow" (12/09/05)

### ATTENTION
The prerequisite Charms for the Abyssal Linguistics Charm "Ghost-Warding Glyph" now correctly include the Occult Charm "Corpus-Rending Blow". **This might render previously saved characters invalid.** Please contact us if you encounter any problems, we will fix your character file.

### Note
There was a bug-ridden release of Anathema 0.8 on the 11th of September.
No use patching, we replaced it.

### Features
+ New Module! The long announced music database debuts
+ Support for the Sidereal Exalted, including
    - A separate view to manage Colleges, complete with point calculation
    - All the charm prerequisites visualized and supported
+ Support for Power Combat
+ All of the "Lost Egg"-Templates from 'The Outcaste'

### Usability
+ Created a shiny new dialog for character template selection.
+ Added progress monitors for most complex actions.
+ Character type and ruleset are displayed on the "Concept and Rules" screen.
* Anathema now uses a simpler dialog for directory browsing.
* Beautified the preferences dialog.
* Unified the all three charm tree views to use a common user interface. (Adressing Features 1146114 and 1146117, both from Xanatos)
* Anathema no longer crashes when changing traits while a charm cascade is loading

### Miscellaneous
+ Caste marks displayed in caste selection
+ First edition of the Anathema Installation Guide released
+ Spanish Website unveiled
- Removed the White-Wolf-style character sheet for Solar Exalted
* Fixed prerequisite Charms for the Abyssal "Ghost-Warding Glyph". SEE RELEASE NOTES!
* Corrected cost and type for the Solar "Iron Skin Concentration". (Thanks to ipsi's Eagle Eye Technique.)
* With two more Necromancy and a final Sorcery-Spell, the database is now truely complete (Thanks to The_Burrito)
* Made available the 'Reputation' background for Realm Dragon-Blooded.
* Fixed the Essence cost for experienced Dragon-Blooded
* Experienced Characters' Willpower is no longer reset to 8 after loading (Bug 1255007, discovered by marwin.at.email.cz)
* Experienced Characters no longer pay XP for specialties learned at creation (Bug 1273947, found by exalted@binary-pulsar.net)


## Release 0.7 Patch 1 (11/07/05)

### Usability
+ Mortals and Heroic Mortals have been consolidated into a single character type
* Results of Breeding are now correctly updated (most shaming Bug 1235133, found by Xanatos)
* Text boxes for virtue flaws are now grayed out when disabled (Bug 1198165, long ago mentioned by Xanatos)
* Abyssal athletics Charms are working once more (Bug 1235216, teaching never to assume - always check)


## Release 0.7 "Gem" (08/07/05)

### Features
+ Character-Type-Time once more: Dynastic Dragon-Blooded join us, bringing
    - A fully modelled Breeding Background
    - The charm set from the DB Core book
    - One more Voidstate-style sheet
+ Finally, the Eclipse/Moonshadow special ability is properly supported
+ Support for variable prerequisite Charms (as in Solar Endurance)
+ Added a field for 'Notes' to the character description panel

### Usability
+ Added a switch to toggle whether printouts are opened directly
* Improved the order of items in the 'New' Menu (Feature 1198880, requested by Xanatos)
* Improved the layout in the experience view (Feature 1198166, also by Xanatos)
* XP table now only accepts numbers (and '-') as valid point values (also part of Feature 1198166)
* The White Wolf character sheet is working once more

### Miscellaneous
+ Martial Arts from Player's Guide and Aspect Book: Earth are included, thanks to the tireless Ricardo Rodriguez
+ All spells officially published are included in the database (Thanks, in part, to J.B.)
+ The charm from Exalted #0 is in. (All Hail UDON.)
* The Bonus Point costs for spell are calculated correctly once again (Bug 1221183, discovered by Eisenstein)
* XP total now properly updates when a table row is removed
* XP table no longer breaks if the currently edited row is removed


## Release 0.6 "Farhold" (12/06/05)

### Features
- A brand new Character Type: Abyssal Exalted, complete with
    - Necromancy (with all the spells from the Abyssals hardback)
    - Fully effective Liege & Necromancy Backgrounds
    - Best-spend calculator for said Backgrounds
    - The complete charm set from the Abyssals fatsplat
    - All the special charms fully modeled
    - A Voidstate-style character sheet
    - Appearance-dependend Essence trait
    - Templates for both loyal and renegade Abyssals
+ A Spanish translation, brought to you by Ricardo Rodriguez
+ An option to select the program's language
+ Some minor improvements on the Solar character sheet
+ Necromancy for Solar Exalted

### Usability
+ The "All Spells" filter in the spell selection view is now limited to allowed circles
+ Specialties are no longer printed if their value is 0

### Miscellaneous
+ All the hot new Charms from Cult of the Illuminated
+ Specialties learned with experience are now removeable
+ Overspent experience points are marked red
* Metal L&F should be fine again
* Willpower now goes all the way to 10 when raised with XP (Bug 1217645, found by Eisenstein)
* Mortal Willpower was limited to 8 by accident. This is remedied.


## Release 0.5 "Eagle's Launch" (08/05/05)

### Features
+ All new character sheet, modeled after the excellent Voidstate sheets (RFE 1173913)
+ Character Advancement at last, consisting of
    - Automatic calculation of your XP spendings
    - An overview of your XP awards
+ Made combos editable
+ Rebuilt the nature system, allowing for
    - Fully customizable natures (via ./data/natures.xml)
    - Showing the nature's willpower recovery condition
+ Plot-Element Drag and Drop now works all across the hierarchy

### Usability
+ Type-specific Icons on main tabs
+ Wait-Cursors are displayed during prolonged actions
+ Preferences can be set in a Dialog in the Extras Menu
+ Style buttons show their current state
* CTRL+SHIFT+Cursor now works as expected in styled text editors
* Special characters (in XML-files) should be saved correctly
* Swapped Magic and Advantages tab as per Xanatos' request (RFE 1192940)

### Miscellaneous
+ Spell learn view shows the number of learned spells
+ Series plot files are only saved when changed
* Fontsize in character overview dependent on screen resolution, not screen size (Most probably fixing Bug 1192945)
* Fixed a wrong resource name for the overwrite warning
* Possibly eliminated a major bug in Series saving/loading
* Heroic Mortals are once more entitled to favored abilities
* Essence Pool values are displayed on smaller displays (Bug 1192944, reported by Xanatos)


## Release 0.4 "Denandsor" (28/03/05)

### Features
+ All-New Series Management Module, beginning with Series Plot Management
+ New item type: Notes (Feature 1150975)
+ Both featuring styled text

### Usability
+ Changed the Tabs in the main view to a more advanced version, thus enabling Close Buttons on the tabs
+ The print dialog now warns when overwriting files.
+ Added a "Save all" action
+ Accelerators and Mnemonics ("Shortcuts")
+ Tooltips for the more ominous buttons
* Clarified Menu-Entries
* Changed the "Print"-toolbar image to a more intuitive PDF-icon
* Line breaks in descriptive texts are kept when saving characters (Feature 1150975)
* Solar Buttons now are somewhat darker to improve visibility (Feature 1145899, requested by Argyle)
* The main menu now has a proper "Exit" entry

### Miscellaneous
+ Command line customizable repository location (Fixing Bug 1100698, initially reported by Shattercrack)
+ Added the Abyssal Hungry Ghost martial arts style to the crowd
+ uteck wrote an Anathema User's Guide, which can be read via the Documentation section on the project page (Feature 1151521, Requested by uteck himself)
+ Xanatos created an icon for Anathema, which is now included in the distribution
+ Anathema website is unveiled
* No more scrollbars in character overview
* "Saving" Charm Cascades is no longer possible (Bug 1150124)
* Fixed the prerequisite Charm for Glorious Solar Plate. (Patch 1151513, submitted by ojastej)
* Ox-Body Technique can be reduced if Endurance value is 0 (Bug 1151991, Thanks to Hilak)
* Combo Restrictions are now properly checked (Bug 1163849) 


## Release 0.3 Patch 1 (23/02/05)

+ Identical Specialties are included into one entry (Feature 1145091, Long time "want to", requested by Xanatos)
+ Background-Color for Martial Arts Charms in Charm Cascades
+ Tiger, Mantis & Ebon Shadow style martial arts added, completing the Solar Martial Arts cascades
+ Added all 5 Immaculate Martial Arts as well as Five-Dragon Style
* Charm Trees are shown once again on Linux systems (Bug 1145262, Special Thanks to Lazarus)
* Combo Boxes in Charm Cascades no longer disappear if window gets too small (Bug 1144803, Submitted by Xanatos)
* Fixed out of memory-Bug with Charm display (Bug 1113973, spotted by Vestrial)
* No more Nullpointer-Exception when deleting a previously entered Virtue Flaw (Bug 1144804, Xanatos again)
* Fixed the prerequisite Charm for Accuracy Without Distance. (Bug 1145027, Thanks to anowack)
* Windows "Thumbs.db" files no longer part of distribution, resulting in smaller download size. (Bug 1145416, Found by Xanatos)
* Removed Character Sheet XML files from distribution, resulting in smaller size again.
* Fixed a wrong resource name for Sidereal "Forward-Thinking Technique"


## Release 0.3 "Chiaroscuro" (20/02/05)

+ Print basic Exalted Character Sheets to PDF
+ No more JDK required to print
+ Charm Data is displayed as tooltips (Feature 1098846)
+ Custom Cursors show the action performed on a Charm 
+ Charm Cascades: An all new Module - view Charm Trees w/o creating characters
    - Sidereal Charm Trees (but no characters yet)
    - Dragon-Blooded Charm Trees (again, no characters)
+ Solar Charm Trees, completely redone
+ Combos are adjusted automatically if component Charms are unlearned.
+ "Clear current Combo"-Button
* Willpower for Solars is no longer limited to 8 (Bug 1105078)
* No more width-jumping overview
* Cleaned up screen layout
* Typos


## Release 0.2 "Bluehaven" (11/01/05)

+ Generate Solar Exalted, including
    - a fully-graphical Charm selection interface
    - easy-to-use Combo generation
    - Sorcery (spells from Exalted only)
    - Virtue Flaws
* Bonus point cost for favored ability specialties is calculated correctly (Thanks to Ky'Tlan)
* No more Nullpointer-Exception when trying to create a new Character Description (Thanks to Xanatos)
* Fixed some typos ("Bonuspoints", "Charactername") (Xanatos)
* Translated the German error notifications (Xanatos, again)
* New distribution scheme with Archives for Updaters, First Timers and Developers (Feature 1087532, Suggested by Xanatos)


## Release 0.1 "Abalone" (28/11/04)

+ Generate Mortals/Heroic Mortals as per Exalted page 103
+ Generate Solars as per Exalted page 104 (no Charms and Sorcery yet)
+ Generate character description
+ Print character description to PDF (requires JDK)
