# Custom Notifications

---

Design Document

Group Members:

Mahesh Gowda

Daniel Hickman

Chris Meyer

James Moore

Liam Palmer

Christian Rosario

## Introduction

Have you ever wanted to make your own custom notifications on your phone? We're creating an app that will allow you to do just that! This simple app that allows for the following:
- Scheduling Notifications on a recurring basis (hourly, every few hours, daily, certain days of the week, every few weeks, or even a day of the year)
- Ability to have a randomly selected notification show from a group of notifications (eg: for custom rotating affirmations or prayers or quotes to memorize)
- Trigger notifications based on location (GPS)

_Use our app for self-improvement: set reminders throughout the day to direct your thought-life, write custom affirmations to speak truth into your morning, let a re-orienting notification trigger whenever you arrive at work, and help yourself memorize the quotes or facts that are most meaningful to you._

## Storyboard

Take a look at our [**interactive InVision storyboard**](https://projects.invisionapp.com/prototype/MobileDev-InVision-for-CustomNotificationsApp-ckkkf2htj0060wu01zxv8loji/play/a80f6ab0) to see our initial envisioning of the app!

We also have images of our storyboards (and the InVision file) in the [Storyboards folder](https://github.com/Razorwind1/CustomNotificationsApp/tree/Storyboards/storyboards) in the repo.

## Functional Requirements

### Overview

1. [Create Notifications](#requirement-10-create-notifications)
2. [Edit Notifications](#requirement-20-edit-notifications)
3. [Delete Notifications](#requirement-30-delete-notifications)
4. [Create Groups](#requirement-40-create-groups)
5. [Delete Groups](#requirement-50-delete-groups)
6. [Toggle Active Notifications](#requirement-60-toggle-active-notifications)

### Requirement 1.0: Create Notifications

#### Scenario

As a user, I want to create a custom notification for a specific time with a certain message so that I receive a notification with that message at that set time.

#### Dependencies

Notifications can be added and saved.

Notifications can be set to repeat on a certain time frame.

#### Assumptions

User has a group created called "Group1"

Notification creation form has the fields:

- Name/Title - Text input
- Body - Text input
- Subtext - Text input
- Date/Time - DateTime input
- Group - Checkbox list input
- Repeat - Toggle switch (default false/off)
  - Cycle (daily, weekly, etc.)
  - Stop date - DateTime input

End date for repeating cannot be earlier than the main date

#### Examples

1.1 - Adding basic notification at single date & time

**Given** I am on the notification list screen

**And** I press the add button

**When** I fill in the form with  
Name: "Do Something"  
Body: "Msg body"  
Subtext: "Msg subtext"  
Date/Time: Jun 13 2021 15:00
Group

**And** I click the save button

**Then** I should see the saved notification on the notification list screen with attributes:
Name: "Do Something"  
Body: "Msg body"  
Subtext: "Msg subtext"  
Date/Time: Jun 13 2021 15:00

1.2 - Adding notification that occurs multiple times

**Given** I am on the notification list screen

**And** I press the add button

**When** I fill in the form with  
Name: "Do Something"  
Body: "Msg body"  
Subtext: "Msg subtext"  
Date/Time: Jun 13 2021 15:00
Recurring: True
Cycle: Daily
End Date: Aug 13 2021

**And** I click the save button

**Then** I should see the saved notification on the notification list screen with attributes:
Name: "Do Something"  
Body: "Msg body"  
Subtext: "Msg subtext"  
Date/Time: Jun 13 2021 15:00  
Repeats: Daily  
Ends: Aug 13 2021

1.3 - Adding notification with group membership

**Given** I am on the notification list screen

**And** I press the add button

**When** I fill in the form with  
Name: "Grouped Notification"  
Date/Time: Jun 13 2021 15:00  
Group: "Group1"

**And** I click the save button

**Then** I should see the saved notification on the notification list screen with attributes:
Name: "Grouped Notification"  
Date/Time: Jun 13 2021 15:00  
Group: "Group1"

**And** I should see the notification "Grouped Notification" listed on the groups page under "Group1"

### Requirement 2.0: Edit Notifications

#### Scenario

As a user, I want to be able to edit notifications so that I can change their details if outdated or incorrect.

#### Dependencies

Notifications can be created and saved.

Notifications can be edited.

Notifications can be deleted.

#### Assumptions

User has 1 notification called "Appointment 1"

Notification edit form has the fields:

- Name/Title - Text input
- Body - Text input
- Subtext - Text input
- Date/Time - DateTime input
- Group - Checkbox list input
- Repeat - Toggle switch (default false/off)
  - Cycle (daily, weekly, etc.)
  - Stop date - DateTime input

#### Examples

2.1 - Editing notification

**Given** I am on the view all notifications page

**And** I expand the "Appointment" notification

**When** I click the edit button

**And** Change name field to "Reminder"

**And** I click the save button

**Then** I should see a notification called "Reminder" and no notification called "Appointment"

### Requirement 3.0: Delete Notifications

#### Scenario

As a user, I want to be able to delete notifications that I no longer want or need.

#### Dependencies

Notifications can be created and saved.

Notifications can be deleted.

#### Assumptions

User has 1 notification called "Appointment 1"

#### Examples

3.1 - Deleting notification

**Given** I am on the view all notifications page

**And** I expand the "Appointment" notification

**When** I click the delete button

**And** I confirm the delete dialog

**Then** I should see no notifications on the view all notifications page

### Requirement 4.0: Create Groups

#### Scenario

As a user, I want to be able to create notification groups so that I can have repeating alerts that are different each time.

#### Dependencies

Notifications can be created and saved.

Groups can be created

#### Assumptions

User has one notification called "Reminder"

Group creation form has fields:

- Name - Text input
- Start Date/Time - DateTime input
- Cycle (daily, weekly, etc.)
- Repeat until - DateTime input (default forever)
- Members - Checkbox list input

#### Examples

4.1 - Creating group with no end date

**Given** I am on the Groups page

**When** I press the add group button

**And** I enter:  
Name: "Daily Reminder"
Start Date/Time: Jan 26 2021 8:00
Cycle: Daily

**And** I select "Reminder" from the members input list

**And** I press the save button

**Then** I should see the group "Daily Reminder"

**And** I should see the single member "Reminder" scheduled to repeat forever on every day after January 26 2021 at 8:00 AM

4.2 - Creating group with an end date

**Given** I am on the Groups page

**When** I press the add group button

**And** I enter:  
Name: "Daily Reminder"
Start Date/Time: Jan 26 2021 8:00
Cycle: Daily
Repeat until: Feb 26 2021 10:00

**And** I press the save button

**Then** I should see the group "Daily Reminder"

**And** I should see that the end date is set for Feb 26 2021 at 10:00 AM

### Requirement 5.0: Delete Groups

#### Scenario

As a user, I want to be able to delete notification groups so I can remove any I do not want or need.

#### Dependencies

Notifications can be created and saved.

Groups can be created

Groups can be deleted

#### Assumptions

User already has two groups "Empty Group" and "Daily Reminders" set up

"Empty Group" has no members

"Daily Reminders" has 1 member, "Reminder"

#### Examples

5.1 - Deleting a notification with no members

**Given** I am on the group page

**When** I click the delete button for the group "Empty Group"

**And** I confirm the delete dialog

**Then** I should no longer see the group "Empty Group" on the groups page

5.2 - Deleting a notification with members

**Given** I am on the group page

**When** I click the delete button for the group "Daily Reminders"

**And** I confirm the delete dialog

**Then** I should no longer see the group "Daily Reminders" on the groups page

**And** The notification "Reminder" should still exist on the view all notifications page

### Requirement 6.0: Toggle Active Notifications

#### Scenario

As a user, I want to be able to toggle notifications so I can manually decide which notifications should be active at any given time.

#### Dependencies

Notifications can be created and saved.

Groups can be created.

Active state of notifications can be toggled.

#### Assumptions

User has one group, "Daily Reminders", created with a member notification called "Say good morning"

Group members have a toggle checkbox in their row in the members section of the expanded group view

Notifications have a toggle checkbox in their row on the view all notifications page

#### Examples

6.1 - Toggling a standalone notification off

**Given** I am on the view all notifications page

**When** I press the checkbox next to the notification labeled "Say good morning"

**Then** I should see that entry is deactivated and I do not get the notification "Say good morning" at its scheduled time.

6.2 - Toggling a group member notification off

**Given** I am on the Groups page

**And** I have expanded the entry for the group "Daily Reminders"

**When** I press the checkbox next to the group member labeled "Say good morning"

**Then** I should see that entry is deactivated and I do not get the notification "Say good morning" at the group's scheduled time.

## Class Diagram

![Class Diagram](#pathOrLinkToDiagram)

### Class Diagram Description

TODO: description

## Scrum Roles

- DevOps/Product Owner/Scrum Master:
  - Daniel Hickman
  - Liam Palmer
- UI Specialists:
  - Chris Meyer
  - James Moore
- Integration Developers:
  - Mahesh Gowda
  - Christian Rosario

## Meetings

Our team is meeting Mondays 3:30-4:30 and Thursdays 9:00-9:30 using Microsoft Teams.
